import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();

        // Добавление записей в телефонную книгу (имя, телефон)
        phoneBook.put("Иванов", "1234567890");
        phoneBook.put("Сычева", "9876543210");
        phoneBook.put("Христофоров", "1211222333");
        phoneBook.put("Малык", "5556667772");
        phoneBook.put("Малык", "5545507666");

        // Создание новой Map для хранения имени и списка его телефонов
        Map<String, String> consolidatedPhoneBook = new HashMap<>();

        // Объединение записей с одинаковыми именами
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            String phone = entry.getValue();

            if (consolidatedPhoneBook.containsKey(name)) {
                // Если имя уже есть в consolidatedPhoneBook, добавляем телефон к существующему списку телефонов
                String existingPhones = consolidatedPhoneBook.get(name);
                consolidatedPhoneBook.put(name, existingPhones + ", " + phone);
            } else {
                // Иначе создаем новую запись
                consolidatedPhoneBook.put(name, phone);
            }
        }

        // Создаем TreeMap для сортировки по убыванию числа телефонов
        TreeMap<Integer, String> sortedPhoneBook = new TreeMap<>((p1, p2) -> p2 - p1);

        // Перекидываем записи из consolidatedPhoneBook в sortedPhoneBook с учетом количества телефонов
        for (Map.Entry<String, String> entry : consolidatedPhoneBook.entrySet()) {
            String name = entry.getKey();
            int numPhones = entry.getValue().split(", ").length;
            sortedPhoneBook.put(numPhones, name + ": " + entry.getValue());
        }

        // Выводим отсортированный результат
        for (Map.Entry<Integer, String> entry : sortedPhoneBook.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}