package company.name.character.clients;

import company.name.enums.ClientRate;
import company.name.enums.TesterCareer;
import company.name.enums.TesterEducation;

public class ClientForC809 extends AbstractClient{

    public ClientForC809() {
        stand = getPreprodStand();
        email = "gateyo4034@mailsecv.com";
        password = "OQFf1j";
        isRegistration = true;

        rate = ClientRate.FREE;

        unusedUxcrowdUsers = 3;
        unusedTheirUsers = 3;

        fioProfile = "Михаил Васильевич Ломоносов";
        dataBirth = "21.12.2000";
        address = "Москва";
        isMan = true;
        isMarried = true;
        education = TesterEducation.SECONDARY_VOCATIONAL;
        career = TesterCareer.SPECIALIST_HIGHER_EDUCATION_WITHOUT_SUBMISSIONS;
        income = "5 000";
        children = 1;
    }
}
