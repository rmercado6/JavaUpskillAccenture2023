package Skills;

import Model.Person;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Streams {

    public void run(List<Person> people) {
        // Filtrar los que viven en méxico y contarlos
        long howManyPeopleWhoLiveInMexico = howManyPeopleWhoLiveInMexico(people);
        System.out.println("En México viven: " + howManyPeopleWhoLiveInMexico + " personas.");

        // Listar a quienes viven en méxico
        List<Person> peopleWhoLiveInMexico = peopleWhoLiveInMexico(people);
        peopleWhoLiveInMexico.forEach(System.out::println);
        System.out.println("\n");

        // Transformar Lista a un mapa <País, Cantidad de personas>
        Map<String, Long> peoplePerCountry = howManyLiveByCountry(people);
        peoplePerCountry.forEach((c, p) -> System.out.println("De la lista de personas, " + p + " personas viven en " + c));
    }

    /***
     * Filtrar los que viven en méxico y contarlos
     * @return long
     ***/
    public long howManyPeopleWhoLiveInMexico(List<Person> people) {
        return people.stream().filter(p -> p.getCountry().equals("MX")).count();
    }

    /***
     * // Listar a quienes viven en méxico
     * @return List of Persons
     */
    public List<Person> peopleWhoLiveInMexico(List<Person> people) {
        return people.stream().filter(p -> p.getCountry().equals("MX")).toList();
    }

    /***
     * Transformar Lista a un mapa <País, Cantidad de personas>
     * @return Map of how many people live in each country
     */
    public Map<String, Long> howManyLiveByCountry(List<Person> people) {
        return people.stream().collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));
    }
}
