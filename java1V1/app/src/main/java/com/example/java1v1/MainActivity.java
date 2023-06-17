package com.example.java1v1;

package com.msaggik.firstlessonstorediscounts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float coat = 70; // пальто
    byte coatDiscount = 77; // скидка (в процентах)
    float hat = 25; // шляпа
    byte hatDiscount = 37;
    float businesssuit = 53; // деловой костюм
    byte businesssuitDiscount = 44;
    float shir = 19; // сорочка
    byte shirDiscount = 0;
    float hoes = 41; // туфли
    byte hoesDiscount = 32;
    float account = 312; // капитал

    // метод подсчёта стоимости серверного комплекта
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (coat * (100 - coatDiscount) + hat * (100 - hatDiscount)
                + businesssuit * (100 - businesssuitDiscount) + shir * (100 - shirDiscount)
                + hoes * (100 - hoesDiscount)) / 100;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки серверного комплекта
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить серверный комплект
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить серверный комплект
            possibilityOut.setText("Имеется достаточно средств для покупки серверного комплекта");
            balanceOut.setText("Остаток от покупки " + balance() + " серебрянных монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки серверного комплекта");
            balanceOut.setText(" - ");
        }
    }
}