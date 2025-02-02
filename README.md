# SpringSecurityTestTask

## Описание

Это демонстрационный проект, построенный с использованием Spring Boot. Для управления зависимостями используется Gradle, а для контейнеризации приложения - Docker.

## Требования

- Docker должны быть установлены на вашей машине.
- Gradle должен быть установлен для сборки проекта.

## Установка и запуск

### Склонируйте репозиторий

```bash
git clone <URL_вашего_репозитория>
```

### Используйте Gradle для сборки проекта

```bash
gradle clean build
```

### Запустите приложение с помощью Docker Compose

```bash
docker-compose up --build
```

## Доступ к приложению

### Приложение будет доступно по адресу: http://localhost:8080
### pgAdmin будет доступен по адресу: http://localhost:5050
- Email: admin@admin.com
- Пароль: root


## Остановка контейнеров
### Для остановки и удаления контейнеров выполнить

```bash
docker-compose down
```
