/* Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, 
используя StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"} */

public class sql {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("SELECT * FROM students WHERE ");
        String temp1 = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"null\"}";
        String temp2 = temp1.replace("\"", "")
                .replace("{", "")
                .replace("}", "")
                .replace(" ", "");
        String[] strArr = temp2.split(",");
        for (int i = 0; i < strArr.length; i++) {
            if (!strArr[i].contains("null")) {
                sb.append(strArr[i].split(":")[0])
                        .append(" = ").append('\'')
                        .append(strArr[i].split(":")[1])
                        .append('\'').append(" AND ");
            }
        }
        sb.replace(sb.length() - 5, sb.length(), "");
        System.out.println(sb);
    }
}