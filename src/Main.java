    public class Main {
        public static void main(String[] args) {
            // Создаём экземпляр нашей HashMap для хранения логинов и ФИ пользователей
            CustomHashMap<String, String> userMap = new CustomHashMap<>();

            System.out.println("=== Демо работы CustomHashMap ===");

            // Добавляем пользователей
            System.out.println("1. Добавляем пользователей:");
            userMap.put("ivanov", "Иван Иванов");
            userMap.put("petrov", "Пётр Петров");
            userMap.put("sidorov", "Сергей Сидоров");
            userMap.printMap();

            // Пытаемся добавить пользователя с уже существующим логином (должно обновить значение)
            System.out.println("2. Обновляем пользователя с логином 'ivanov':");
            userMap.put("ivanov", "Иван Иванович Иванов");
            userMap.printMap();

            // Получаем информацию о пользователе
            System.out.println("3. Получаем информацию о пользователях:");
            String user1 = userMap.get("ivanov");
            String user2 = userMap.get("kuznetsov"); // Такого пользователя нет

            System.out.println("Пользователь с логином 'ivanov': " + user1);
            System.out.println("Пользователь с логином 'kuznetsov': " + user2);

            // Удаляем пользователя
            System.out.println("4. Удаляем пользователя с логином 'petrov':");
            boolean isRemoved = userMap.remove("petrov");
            System.out.println("Удаление прошло успешно: " + isRemoved);
            userMap.printMap();

            // Попытка удалить несуществующего пользователя
            System.out.println("5. Попытка удалить пользователя с логином 'smirnov' (не существует):");
            boolean isRemoved2 = userMap.remove("smirnov");
            System.out.println("Удаление прошло успешно: " + isRemoved2);
            userMap.printMap();
        }
    }
