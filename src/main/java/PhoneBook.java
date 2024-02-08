import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Добавляем данные в телефонную книгу
        addContact(phoneBook, "Иванов", "1234567890");
        addContact(phoneBook, "Малык", "9876543210");
        addContact(phoneBook, "Сычева", "2468101214");
        addContact(phoneBook, "Христофоров", "5555552345");
        addContact(phoneBook, "Малык", "9655507666");

        // Сортируем по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> sortedContacts = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(sortedContacts, new Comparator<Map.Entry<String, Set<String>>>() {
            @Override
            public int compare(Map.Entry<String, Set<String>> entry1, Map.Entry<String, Set<String>> entry2) {
                return entry2.getValue().size() - entry1.getValue().size();
            }
        });

        // Выводим данные
        for (Map.Entry<String, Set<String>> entry : sortedContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void addContact(Map<String, Set<String>> phoneBook, String name, String phone) {
        phoneBook.putIfAbsent(name, new HashSet<>());
        phoneBook.get(name).add(phone);
    }
}
