#!/bin/bash
# Script de teste para configurar Fedora base + Remmina em sistema TTY existente
# Execute como root ou com sudo

set -e  # Parar em caso de erro

echo "=================================="
echo "TESTE: Fedora Base + Remmina (TTY)"
echo "=================================="

# Verificar se está rodando como root
if [ "$EUID" -ne 0 ]; then 
    echo "Por favor, execute como root (sudo $0)"
    exit 1
fi

# Função para log
log() {
    echo "[$(date '+%H:%M:%S')] $1"
}

log "Iniciando configuração do sistema base..."

# 1. ATUALIZAR SISTEMA BASE
log "1/8 - Atualizando sistema..."
dnf update -y

# 2. INSTALAR PACOTES NECESSÁRIOS
log "2/8 - Instalando pacotes essenciais..."
dnf install -y \
    xorg-x11-server-Xvfb \
    xorg-x11-server-Xorg \
    xorg-x11-xinit \
    xorg-x11-drivers \
    mesa-dri-drivers \
    openbox \
    obmenu \
    obconf \
    remmina \
    remmina-plugins-rdp \
    freerdp \
    gtk3 \
    dejavu-fonts-common \
    dejavu-sans-fonts \
    dejavu-sans-mono-fonts \
    NetworkManager \
    NetworkManager-tui

# 3. CRIAR USUÁRIO GUEST (se não existir)
log "3/8 - Configurando usuário guest..."
if ! id "guest" &>/dev/null; then
    useradd -m -G wheel guest
    echo "guest:guest" | chpasswd
    log "Usuário 'guest' criado com senha 'guest'"
else
    log "Usuário 'guest' já existe"
fi

# 4. CONFIGURAR ESTRUTURA DE DIRETÓRIOS
log "4/8 - Criando estrutura de diretórios..."
mkdir -p /home/guest/.local/share/remmina
mkdir -p /home/guest/.config/openbox
mkdir -p /home/guest/scripts

# 5. CONFIGURAR XINITRC
log "5/8 - Configurando .xinitrc..."
cat > /home/guest/.xinitrc << 'EOF'
#!/bin/bash
# Configurar display
export DISPLAY=:0

# Inicializar OpenBox em background
openbox-session &
WM_PID=$!

# Aguardar OpenBox inicializar
sleep 3

# Executar Remmina com conexão específica
echo "Iniciando Remmina..."
exec remmina -c /home/guest/.local/share/remmina/empresa.remmina
EOF

chmod +x /home/guest/.xinitrc

# 6. CRIAR ARQUIVO DE CONEXÃO RDP
log "6/8 - Criando configuração RDP..."
cat > /home/guest/.local/share/remmina/empresa.remmina << 'EOF'
[remmina]
password=
name=SFC_RDS - Ferreira Costa
protocol=RDP
server=FCIMB-RDSHO.FERREIRACOSTA.LOCAL:3389
username=
domain=FERREIRACOSTA.LOCAL
resolution_mode=4
color_depth=32
sound=local
microphone_redirect=1
clipboard-sync=1
reconnect_if_failed=1
ssh_tunnel_enabled=0
disablepasswordstoring=0
quality=0
network=0
security=
cert_ignore=1
gateway_server=
gateway_username=
gateway_domain=
gateway_password=
precommand=
postcommand=
# Configurações específicas do RemoteApp
exec=||SFC_RDS
execpath=
loadbalanceinfo=tsv://MS Terminal Services Plugin.1.RemoteApp_RDSHO
workarea=1
span_monitor=1
multimon=1
printer_overrides=
smartcardname=
serialname=
serialdriver=
serialpath=
parallelname=
parallelpath=
# Redirecionamentos
redirectclipboard=1
redirectprinters=1
redirectcomports=0
redirectsmartcards=1
redirectdrives=1
drivestoredirect=*
devicestoredirect=*
# Configurações de sessão
sessionbpp=32
prompt_for_credentials=1
allow_font_smoothing=1
videoplaybackmode=1
audiocapturemode=1
gatewayusagemethod=0
gatewayprofileusagemethod=1
gatewaycredentialssource=0
use_client_keyboard=1
console_session=0
EOF

# 7. CONFIGURAR OPENBOX
log "7/8 - Configurando OpenBox..."
cat > /home/guest/.config/openbox/autostart << 'EOF'
# OpenBox autostart - aguardar e iniciar Remmina
(sleep 2 && remmina -c /home/guest/.local/share/remmina/empresa.remmina) &
EOF

chmod +x /home/guest/.config/openbox/autostart

# Configuração básica do OpenBox
cat > /home/guest/.config/openbox/rc.xml << 'EOF'
<?xml version="1.0" encoding="UTF-8"?>
<openbox_config xmlns="http://openbox.org/" xmlns:xi="http://www.w3.org/2001/XInclude">
  <resistance>
    <strength>10</strength>
    <screen_edge_strength>20</screen_edge_strength>
  </resistance>
  <focus>
    <focusNew>yes</focusNew>
    <followMouse>no</followMouse>
    <focusLast>yes</focusLast>
    <underMouse>no</underMouse>
    <focusDelay>200</focusDelay>
    <raiseOnFocus>no</raiseOnFocus>
  </focus>
  <theme>
    <name>Clearlooks</name>
    <titleLayout>NLIMC</titleLayout>
    <keepBorder>yes</keepBorder>
    <animateIconify>yes</animateIconify>
    <font place="ActiveWindow">
      <name>sans</name>
      <size>8</size>
    </font>
    <font place="InactiveWindow">
      <name>sans</name>
      <size>8</size>
    </font>
  </theme>
</openbox_config>
EOF

# 8. CRIAR SCRIPT DE INICIALIZAÇÃO
log "8/8 - Criando scripts de inicialização..."
cat > /home/guest/scripts/start-session.sh << 'EOF'
#!/bin/bash
# Script para iniciar sessão X11 automaticamente

export DISPLAY=:0
cd /home/guest

echo "Iniciando servidor X11..."
startx /home/guest/.xinitrc -- :0 vt1 -keeptty
EOF

chmod +x /home/guest/scripts/start-session.sh

# Configurar .bash_profile
cat > /home/guest/.bash_profile << 'EOF'
# Auto-start X session na primeira TTY
if [ -z "$DISPLAY" ] && [ "$XDG_VTNR" = "1" ]; then
    echo "Iniciando sessão gráfica automaticamente..."
    exec /home/guest/scripts/start-session.sh
fi

# Carregar .bashrc se existir
if [ -f ~/.bashrc ]; then
    . ~/.bashrc
fi
EOF

# Definir permissões corretas
chown -R guest:guest /home/guest
chmod 600 /home/guest/.local/share/remmina/empresa.remmina

# CONFIGURAR AUTO-LOGIN (OPCIONAL - para teste manual, deixar comentado)
log "Configuração de auto-login disponível (desabilitada para teste)"
cat > /tmp/auto-login-config.txt << 'EOF'
Para habilitar auto-login do usuário guest, execute:

mkdir -p /etc/systemd/system/getty@tty1.service.d
cat > /etc/systemd/system/getty@tty1.service.d/override.conf << 'AUTOEOF'
[Service]
ExecStart=
ExecStart=-/usr/sbin/agetty --autologin guest --noclear %I $TERM
AUTOEOF

systemctl daemon-reload
systemctl restart getty@tty1.service
EOF

echo ""
echo "=================================="
echo "CONFIGURAÇÃO CONCLUÍDA!"
echo "=================================="
echo ""
echo "PRÓXIMOS PASSOS PARA TESTE:"
echo ""
echo "1. Para testar manualmente:"
echo "   su - guest"
echo "   /home/guest/scripts/start-session.sh"
echo ""
echo "2. Para testar Remmina diretamente:"
echo "   su - guest"
echo "   remmina -c /home/guest/.local/share/remmina/empresa.remmina"
echo ""
echo "3. Para verificar se X11 está funcionando:"
echo "   su - guest"
echo "   startx"
echo ""
echo "4. Para habilitar auto-login (CUIDADO!):"
echo "   cat /tmp/auto-login-config.txt"
echo ""
echo "INFORMAÇÕES:"
echo "- Usuário: guest"
echo "- Senha: guest" 
echo "- Servidor RDP: 10.131.1.134:3389"
echo "- Arquivo de conexão: /home/guest/.local/share/remmina/empresa.remmina"
echo ""
echo "LOGS IMPORTANTES:"
echo "- Xorg: /var/log/Xorg.0.log"
echo "- Journal: journalctl -u getty@tty1.service"
echo ""