# Инструкция для запуска приложения

### Проверить установленный Maven

```shell
mvn --version
```

#### Если не установлен:

#### Ubuntu/Debian:

```shell
sudo apt install maven
```

#### macOS:

```bash
brew install maven
```

#### Windows: скачать с

```text
https://maven.apache.org/
```

### Сборка и запуск

#### Перейти в директорию проекта

```shell
cd pr1
```

#### Скомпилировать и запустить приложение

```shell
mvn clean compile exec:java
```

