
class Pierwsze{
    max_val;
    constructor(max_val){
        this.max_val = max_val;

    }

    checkPrime(number) {
        if (number === 1) return false;
      
        for (let i = 2; i < number; i++) {
          if (number % i === 0) return false;
        }
        return true;
      }
      
    printPrime(count) {
        let values = "";
        for (let i = 1; i <= count; i++) {
          if (checkPrime(i)) {
            values += i + " ";
          }
        }
        let testcase = document.getElementById("news2");
        testcase.innerHTML = values;
      }

    validate(){
        if(this.max_val == null || isNaN(+this.max_val) || this.max_val < 0)
            return false;
        return true;
    }
    liczbyPierwsze(){
        let lista = document.getElementById("lista");

        if(lista.hasChildNodes()){
            while(lista.firstChild) {
                lista.removeChild(lista.firstChild);
            }
        }
        let ol = document.createElement("ol");

        for (let i = 2; i <= this.max_val; i++){
            if(this.checkPrime(i)){
                let li = document.createElement("li");
        

                let liText = document.createTextNode(i);
                li.appendChild(liText);
                ol.appendChild(li);
                console.log(i);
                
            }
        }
        lista.appendChild(ol);
    }
    licz(){
        if(this.validate()){
            this.liczbyPierwsze();
        } else{
            alert("Nie podano prawidłowych danych");
        }
    }
    
}

function podpiecie() {
    let element = document.getElementById("licz");
    element.addEventListener("click", function(event){
        let a = document.getElementById("wsp_a").value;


        let p = new Pierwsze(a);
        p.licz();
    });
}