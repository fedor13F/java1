# Инструкция для запуска приложения

#### Клонирование репозитория
```shell
git clone https://github.com/fedor13F/java1.git
```

#### Проверить установленный Maven

```shell
mvn --version
```

#### Если не установлен:

#### Linux:

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
cd java1
```

#### Скомпилировать и запустить приложение

```shell
mvn clean compile exec:java
```

