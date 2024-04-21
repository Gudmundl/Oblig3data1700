
function buyTicket() {
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let film = document.getElementById('film').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let quantity = document.getElementById('quantity').value;
//checks if values are there and corrext
    if (!validateEmail(email)) {
        alert('Vennligst skriv inn en gyldig e-postadresse.');
    } else if (!validatePhone(phone)) {
        alert('Vennligst skriv inn et gyldig telefonnummer.');
    } else if (!validateName(firstName)) {
        alert('Vennligst skriv inn et gyldig fornavn.');
    } else if (!validateName(lastName)) {
        alert('Vennligst skriv inn et gyldig etternavn.');
    } else if (!film) {
        alert('Vennligst velg en film.');
    } else if (!quantity) {
        alert('Vennligst skriv inn et antall.');
    } else {


        sendTicketsDb();
        getDbTickets();

    }

}
//regex for first names
function validateName(name) {
    const re = /^[a-zA-ZæøåÆØÅ\- ]+$/;
    return re.test(name);
}
//regex for email
function validateEmail(email) {
    const re = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return re.test(email);
}
//regex for phone
function validatePhone(phone) {
    const re = /^(0047|\+47|47)?\d{8}$/;
    return re.test(phone);
}


function sendTicketsDb() {
    const ticketItem = {
        filmer: $("#film").val(),
        antallBiletter: $("#quantity").val(),
        fornNavn: $("#firstName").val(),
        etterNavn: $("#lastName").val(),
        telefonNr: $("#phone").val(),
        epost: $("#email").val()
    };
    $.post("/lagre", ticketItem, function(){
    });
    //clears form
    document.getElementById("ticketForm").reset();
}

function  getDbTickets(){
    $.get("/hentBilletter", function(BilletterVis){
        showDbTickets(BilletterVis);
    });
}
function showDbTickets(BilletterVis){

    let ut = "";
    for (let ticket of BilletterVis){
        ut += "Film: " + ticket.film + " Antall: " + ticket.quantity + " Navn: " + ticket.firstName + " " + ticket.lastName + " Telefon: " + ticket.phone + " Epost: " + ticket.email + "<br>";
    }
    document.getElementById("ticketList").innerHTML = ut;



    /*BilletterVis.f   orEach(BilletterVis)
        let row = document.createElement("tr");

    let nameCell = document.createElement("td");
    nameCell.textContent = BilletterVis.firstName+BilletterVis.lastName;
        row.appendChild(nameCell);


    let filmCell = document.createElement("td");
    filmCell.textContent = BilletterVis.film;
        row.appendChild(filmCell);

    let emailCell = document.createElement("td");
    emailCell.textContent = BilletterVis.email;
        row.appendChild(emailCell);

        ticketList.appendChild(row);
*/
}
//clears tickets table
function clearTickets() {
    $.post("/slett", function(){
        getDbTickets();
    });
}



