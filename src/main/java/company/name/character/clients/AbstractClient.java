package company.name.character.clients;

import company.name.character.AbstractCharacter;
import company.name.enums.TesterCareer;
import company.name.enums.TesterEducation;

public abstract class AbstractClient extends AbstractCharacter {

    /**
     * Стенд для теста, email, пароль, зарегестрирован или нет, его тариф
     */
    public String stand;
    public String email;
    public String password;
    public boolean isRegistration;
    public Enum rate;

    /**
     * Данные для регистрации (имя, должность, имя компании, номер телефона, сайт
     */

    public String name;
    public String position;
    public String company;
    public String numberPhone;
    public String site;

    /**
     * Доступные пользователи для тестирования
     */

    public int unusedUxcrowdUsers;
    public int unusedTheirUsers;

    /**
     * Поля для создания теста. Имя теста, тестируемый сайт, информация, имя сегмента, задачи
     */
    public String nameTest;
    public String siteTest;
    public String information;
    public String segmentName;
    public String task;

    /**
     * Поля данных профиля
     */

    public String fioProfile;
    public String dataBirth;
    public String address;
    public boolean isMan;
    public boolean isMarried;
    public TesterEducation education;
    public TesterCareer career;
    public String income;
    public int children;
}


