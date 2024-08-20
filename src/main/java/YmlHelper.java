import utils.YmlParser;
import utils.YmlReader;
import utils.YmlWriter;

import java.util.Scanner;

public class YmlHelper {
    public static void main(String[] args) {
        var reader = new YmlReader();
        var parser = new YmlParser();
        var writer = new YmlWriter();

        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Введите имя файла yml или exit для выхода: ");
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            var fileName = input;

            System.out.println("Введите имя подпапки или exit для выхода: ");
            input = scanner.nextLine();
            var subDir = input;
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            var source = reader.readDatasetConfig("./source/" + fileName);
            var list = parser.parseYml(source);
            writer.writeList(list, subDir);
            System.out.println();

        }
    }
}
