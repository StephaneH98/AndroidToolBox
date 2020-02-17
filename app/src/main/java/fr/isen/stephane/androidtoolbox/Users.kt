package fr.isen.stephane.androidtoolbox

class Users {
    var name: String = ""
    var surname: String = ""
    var birthday: String = ""

    constructor()

    constructor(name: String, surname: String, date: String)
    {
        this.name = name
        this.surname = surname
        this.birthday = date
    }
}