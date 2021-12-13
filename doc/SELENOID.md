## Selenoid

### Для запуска тестов через селеноид в докер контейнере (Windows):
    Установить Docker desktop app
    установить wsl 2
    скачать selenoid https://github.com/aerokube/cm/releases
    запустить selenoid 
        ./cm.exe selenoid start --vnc  
        ./cm.exe selenoid-ui start
    в конфигурации проекта в DriverConfig.properties указать запуск selenoid
    
