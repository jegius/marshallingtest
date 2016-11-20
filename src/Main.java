import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        //Создаем объекты
//        Adress adressOne = new Adress("Toglytti", "Voroshilova");
//        Adress adressTwo = new Adress("Toglytti", "st. Razina");
//        Adress adressThree = new Adress("Toglytti", "Dzerjinskogo");
//
//
//        Product one = new Product("Phone", 12000, adressOne);
//        Product two = new Product("TV", 22000, adressTwo);
//        Product three = new Product("NoteBook", 42000, adressThree);
//        Product four = new Product("Split system", 52000,  adressThree);
//
//        Catalog catalog = new Catalog();
//        catalog.add(one);
//        catalog.add(two);
//        catalog.add(three);
//        catalog.add(four);
//
//
//        //указываем путь куда будет сохранен xml файл и имя файла
//        File file = new File("out/test.xml");
//
//
//        try {
//
//            // Создаем экзкмпляр утитлиты JAXB, в качестве аргумента
//            // передается ссылка на базовай класс экспортируемого объекта
//
//            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
//
//            // Создаем экземпляр маршаллера
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            // Дополнительный параметр для форматирования XML документа
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            // Метод маршал записывающий данные в файл. catalog- ссылка на наш каталог,
//            // file - путь в место куда нужно записать файл.
//            jaxbMarshaller.marshal(catalog, file);
//
//            System.out.println("File Export was successful! Path: '" + file.getPath() + "'");
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }


        //   Для анмаршалинга нам понадобится ссылка на объект загружаемого файла.
        Catalog catalog = null;
        //   Путь к импортируемому файлу
        File file = new File("out/test.xml");
        try {
            // Экземпляр улиты JAXB в качестве аргумента принемающая ссылку на класс принимаемого объекта
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);

            // Экземпляр анмаршаллера
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Получаемый при анмаршаллинге файл будет типа Object,
            // поэтому для того чтобы сохранить его понадобится привести его к соответствующему типу
            catalog = (Catalog) unmarshaller.unmarshal(file);
            System.out.println("File Import was successful! Path: '" + file.getPath() + "'");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Проверка данных полученных при анмаршалинге

        List<Product> products = catalog.getProducts();
        System.out.println("Всего объектов импортированно: " + products.size());
        for (Product p : products) {
            System.out.println("============================");
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("----------------------------");
            System.out.println("City: " + p.getAdress().getCity());
            System.out.println("Street: " + p.getAdress().getStreet());
        }
    }
}
