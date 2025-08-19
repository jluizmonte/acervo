#!/bin/bash
# Script de configuração para login automático e modo quiosque Remmina
# Execute como root

echo "=== Configurando Login Automático para usuário kiosk ==="

# 1. Configurar login automático no systemd
mkdir -p /etc/systemd/system/getty@tty1.service.d/
cat > /etc/systemd/system/getty@tty1.service.d/override.conf << 'EOF'
[Service]
ExecStart=
ExecStart=-/sbin/agetty --noissue --autologin kiosk %I $TERM
Type=idle
EOF

# 2. Criar perfil Remmina para o usuário kiosk
mkdir -p /home/kiosk/.local/share/remmina
cat > /home/kiosk/.local/share/remmina/SFC_RDS.remmina << 'EOF'
[remmina]
password=
name=SFC_RDS
protocol=RDP
server=FCIMB-RDSHO.FERREIRACOSTA.LOCAL:3389
username=
domain=
resolution_mode=1
color_depth=32
shareprinter=1
shareclipboard=1
shareserial=0
sharesmartcard=1
sharefolder=
sound=local
ssh_enabled=0
ssh_loopback=0
ssh_server=
ssh_username=
ssh_password=
ssh_privatekey=
viewmode=1
scaler_expand=0
toolbar_pin=0
disableclipboard=0
disableserverbell=1
disableserverbeep=1
smartcardname=
dvc=
precommand=
postcommand=
relax-order-checks=0
glyph-cache=0
colordepth=32
quality=0
security=
disable_smooth_scrolling=0
disable_menu_effects=0
disable_theming=0
disable_wallpaper=0
enable-autostart=1
useconsole=0
shareprinters=1
disablepasswordstoring=0
keymap=
microphone_redirect=1
multimon=1
span=1
drive_redirect=1
printer_redirect=1
serialport_redirect=0
smartcard_redirect=1
sound_redirect=1
usb_redirect=1
clipboard_redirect=1
ignore-tls-errors=1
old-license=0
restricted-admin=0
suppress-output=0
tls-seclevel=
network=modem
monitorids=
cert_ignore=0
gateway_server=
gateway_username=
gateway_password=
gateway_domain=
loadbalanceinfo=tsv://MS Terminal Services Plugin.1.RemoteApp_RDSHO
remoteprogram=||SFC_RDS
remoteprogram2=||SFC_RDS
workarea=0
span_monitors=1
drive_redirection_mode=0
printer_redirection_mode=0
smartcard_redirection_mode=1
usb_redirection_mode=1
audio_redirection_mode=1
microphone_redirection_mode=1
multimon_config=0
base_cred_for_gw=0
gateway_usage=0
prompt_for_credentials=1
disable_fastpath=0
clientname=
clientbuild=
enable_gateway=0
disableclipboard=0
clienthostname=
alternate_shell=||SFC_RDS
shell_working_directory=
exec_path=||SFC_RDS
exec_cmd_line=
load_balance_info=tsv://MS Terminal Services Plugin.1.RemoteApp_RDSHO
workspace_id=FCIMB-RDSHO.ferreiracosta.local
use_client_keyboard=1
console_session=0
server_layout=
keyboard_grab=0
decorations=0
fullscreen_on_auto=1
always_show_tab=0
hide_connection_toolbar=0
minimize_to_tray=0
ssh_tunnel_loopback=0
ssh_tunnel_fallback=0
use_profile=0
enable_avahi=1
shareserial=0
serialname=
serialdriver=
serialpath=
redirection_domain=
redirection_username=
redirection_password=
left-handed-mouse=0
disable_fastpath=0
multitransport=0
base_cred_for_gw=0
gateway_usage=0
prompt_for_credentials=1
ignore_certificate=0
old_license=0
restricted_admin_mode=0
password_hash=
precommand_wait=0
postcommand_wait=0
run_line=
ssh_tunnel_certfile=
ssh_tunnel_privatekey=
ssh_tunnel_passphrase=
ssh_stricthostkeycheck=0
fingerprint=
cert_ignore=0
EOF

# 3. Configurar .bashrc para iniciar Remmina automaticamente
cat > /home/kiosk/.bashrc << 'EOF'
# .bashrc para usuário kiosk

# Se não for uma sessão interativa, não fazer nada
[[ $- != *i* ]] && return

# Verificar se está no TTY1 (login automático)
if [[ $(tty) == "/dev/tty1" ]]; then
    echo "Iniciando modo quiosque..."
    
    # Aguardar um momento para o sistema estabilizar
    sleep 2
    
    # Iniciar Remmina em modo quiosque com a conexão padrão
    # O --kiosk inicia em tela cheia
    # O -c conecta automaticamente ao perfil especificado
    remmina --kiosk -c /home/kiosk/.local/share/remmina/SFC_RDS.remmina &
    
    # Aguardar o Remmina iniciar
    sleep 3
    
    # Loop para manter o sistema ativo e reiniciar Remmina se necessário
    while true; do
        if ! pgrep -x "remmina" > /dev/null; then
            echo "Remmina não está rodando, reiniciando..."
            remmina --kiosk -c /home/kiosk/.local/share/remmina/SFC_RDS.remmina &
        fi
        sleep 10
    done
fi
EOF

# 4. Criar script de inicialização alternativo (systemd service)
cat > /etc/systemd/system/remmina-kiosk.service << 'EOF'
[Unit]
Description=Remmina Kiosk Mode
After=graphical-session.target
Wants=graphical-session.target

[Service]
Type=simple
User=kiosk
Group=kiosk
Environment=DISPLAY=:0
Environment=HOME=/home/kiosk
Environment=XDG_RUNTIME_DIR=/run/user/1000
ExecStartPre=/bin/sleep 5
ExecStart=/usr/bin/remmina --kiosk -c /home/kiosk/.local/share/remmina/SFC_RDS.remmina
Restart=always
RestartSec=3

[Install]
WantedBy=multi-user.target
EOF

# 5. Configurar permissões
chown -R kiosk:kiosk /home/kiosk/.local/
chown kiosk:kiosk /home/kiosk/.bashrc
chmod 755 /home/kiosk/.local/share/remmina/
chmod 600 /home/kiosk/.local/share/remmina/SFC_RDS.remmina

echo "=== Configuração concluída ==="
echo ""
echo "Para ativar as configurações:"
echo "1. systemctl daemon-reload"
echo "2. systemctl enable getty@tty1.service"
echo "3. systemctl enable remmina-kiosk.service (opcional)"
echo "4. reboot"
echo ""
echo "O sistema irá:"
echo "- Fazer login automático no usuário 'kiosk'"
echo "- Iniciar o Remmina automaticamente em modo quiosque"
echo "- Conectar automaticamente ao servidor RDS configurado"
echo ""
echo "Para sair do modo quiosque: Ctrl+Alt+F2 e faça login como root"
