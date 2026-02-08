# Компиляция проекта
build:
	@./gradlew clean build

# Запуск проверки
check:
	@./gradlew check

# Установка зависимостей
installDist:
	@./gradlew installDist

# Запуск приложения с передачей аргументов
run-dist:
	@./build/install/app/bin/app

# Очистка проекта
clean:
	@./gradlew clean

# Проверка уязвимостей зависимостей
check-updates:
	@./gradlew dependencyUpdates

# Проверка стиля кода
lint:
	@./gradlew checkstyleMain

# Сборка проекта (всегда выполняет сборку)
.PHONY: build