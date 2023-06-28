

function funkcje() {
    let news1 = document.getElementById('news1');
    let news2 = document.getElementById('news2');


    news1.innerHTML = powitanie()+"<br/>"+data()+"<br/>";
    news2.innerHTML = doUrodzin();

}

function zegarek() {
    let data = new Date();
    let godzina = data.getHours();
    let minuta = data.getMinutes();
    let sekunda = data.getSeconds();

    if(minuta < 10) minuta = "0" + minuta;
    if(sekunda < 10) sekunda = "0" + sekunda;
    let stopka = document.getElementById("stopka");
    stopka.innerHTML = "&copy;2023 MR | " + godzina + ":" + minuta + ":" + sekunda;
}


function powitanie() {
    let dzisiaj = new Date();
    let godzina = dzisiaj.getHours();
    if((godzina < 18) && (godzina > 6)){
        return "Dzień dobry,";
    } else{
        return "Dobry wieczór,";
    }
}

var miesiace = [ "stycznia", "lutego", "marca", "kwietnia", "maja", "czerwca", "lipca", "sierpnia", "wrzesnia", "października", "listopada", "grudnia" ];

function data() {
    let dzisiaj = new Date();
    let dzień = dzisiaj.getDate();
    let miesiac = miesiace[dzisiaj.getMonth()];
    let rok = dzisiaj.getFullYear();

    return "dzisiaj jest " + dzień + " " + miesiac + " " + rok + "r.";

}


function doUrodzin() {
    let todayDate = new Date();
    let year = todayDate.getFullYear();
    let birthdayDate = new Date(year, 8, 14);

    let daysToBirthday = todayDate - birthdayDate;
    let days;
    let to_return;
    days = Math.floor(daysToBirthday / (24*60*60*1000));
    if(daysToBirthday > 0){
        to_return ="Autor miał urodziny " + Math.abs(days) + " dni temu";
    }
    else{
        to_return ="Autor bedzie miał urodziny za  " + Math.abs(days) + " dni";
    }
    to_return  += " (" + (birthdayDate.getDate()+1) +" "+ miesiace[birthdayDate.getMonth()] + " " + birthdayDate.getFullYear() + ")";


    return to_return;
}