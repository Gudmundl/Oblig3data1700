
function buyTicket() {
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    let firstName = document.getElementById('firstName').value;
    let lastName = document.getElementById('lastName').value;
    let quantity = document.getElementById('quantity').value;
    let film = document.getElementById('film').value;
//checks if values are there and correct
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
        email: $("#email").val(),
        phone: $("#phone").val(),
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        quantity: $("#quantity").val(),
        film: $("#film").val()
    };

    $.post("/saveTicket", ticketItem, function(){
    });
    //clears form
    document.getElementById("ticketForm").reset();
}

function  getDbTickets(){
    $.get("/getTicketsDB", function(VisBilletter){

        showDbTickets(VisBilletter);
    });
}
function showDbTickets(VisBilletter) {
    let resetTbody = document.getElementById("ticketList");
    resetTbody.innerHTML = '';
    let ticketList = document.getElementById("ticketList");

    for (let ticketItem of VisBilletter) {
        let row = document.createElement("tr");

        let idCell = document.createElement("td");
        idCell.textContent = ticketItem.id;
        row.appendChild(idCell);

        let nameCell = document.createElement("td");
        nameCell.textContent = ticketItem.firstName + " " + ticketItem.lastName;
        row.appendChild(nameCell);

        let emailCell = document.createElement("td");
        emailCell.textContent = ticketItem.email;
        row.appendChild(emailCell);

        let phoneCell = document.createElement("td");
        phoneCell.textContent = ticketItem.phone;
        row.appendChild(phoneCell);

        let filmCell = document.createElement("td");
        filmCell.textContent = ticketItem.film;
        row.appendChild(filmCell);

        let quantCell = document.createElement("td");
        quantCell.textContent = ticketItem.quantity;
        row.appendChild(quantCell);

        ticketList.appendChild(row);
    }
}




//clears tickets table
function clearTickets() {
    $.post("/deleteAll", function(){
        getDbTickets();
    });
}

function deleteTicketId(){
    let idForDelete = {id: $("#deleteWithId").val()}
    $.post("/deleteOne", idForDelete, function () {
    });
    document.getElementById("deleteIdForm").reset();
}

