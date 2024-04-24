package ru.example.example_3_seminar_3_Homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.example_3_seminar_3_Homework.domain.User;
import ru.example.example_3_seminar_3_Homework.services.DataProcesingService;

/*1) В класс RegistrationService добавить поля UserService, NotificationService
(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)
2) Разработать метод processRegistration в котором:
- создается пользователь из параметров метода
- созданный пользователь добавляется в репозиторий
- через notificationService выводится сообщение в консоль
3) В TaskController добавить обработчики filterUsersByAge()
(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable*/
@Service

public class RegisrtationService {

    private DataProcesingService dataProcesingService;

    public RegisrtationService(DataProcesingService dataProcesingService,
                               UserService userService, NotificationService notificationService) {
        this.dataProcesingService = dataProcesingService;
        this.userService = userService;
        this.notificationService = notificationService;
    }

    public DataProcesingService getDataProcessingService(){
        return dataProcesingService;

    }


    private UserService userService;


    private NotificationService notificationService;
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }

    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
    public String proccesRegistration(String name,int age,String email){
        User user=userService.createUser( name, age, email);
        dataProcesingService.addUserToList(user);
        return notificationService.notifyUser(user);

    }


}













