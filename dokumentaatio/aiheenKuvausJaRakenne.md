**Aihe**


CatSweeperi on minesweeper peli, jossa miinat on korvattu kissoilla!
Pelaaja voi valita eri kokoisista kartoista (small, medium, large). Pelaaminen toimii kuten normaalissa minesweepperissä.
Kun pelaaja valitsee ruudun, jossa on kissa, hän häviää (ja hänet raadellaan julmasti). Jos ruudussa ei ole kissaa
tulee näkyviin numero, joka kertoo kuinka monta kissaa on lähiruuduissa. Jos ruudun vieressä on ruutu, jonka vieressä ei ole
yhtään kissaa paljastuu tämä ruutu.

**Käyttäjät** : Pelaaja

**Toiminnot**:
* Muuta kartan kokoa (pelin alussa)
* Aloita peli
* Aloita peli uudestaan häviön jälkeen
* Valitse ruutu, joka on
  * tyhjä
  * kissa
* Liputa ruutu

**Luokkakaavio**

![Luokkakaavio puuttuu kuvat tiedostosta, korjataan pian!](/dokumentaatio/kuvat/JAVALuokkaKaavio.png)

![Sekvenssikaavio puuttuu kuvat tiedostosta, korjataan pian!](/dokumentaatio/kuvat/Kissan%20clickaus.png)

![Sekvenssikaavio puuttuu kuvat tiedostosta, korjataan pian!](/dokumentaatio/kuvat/Merkkaa%20ruutu%20lipulla.png)


**Rakennekuvaus**

Tile on rakenteen peruspilari. Se kuvaa miinaharavan ruutua, jolla on arvo ja koordinaatit. Sen voi myös olla liputettu, paljastettu ja pommi. Pelilauta eli luokka MineField sisältää lautaan liittyvän logiikan. Sillä on private Tile[][]Boardi, johon kaikki Tilet kuuluvat. Luokka sisältää kaikki metodit pommien alustamiseen, ruutujen arvojen laskemiseen ja naapureiden selvittämiseen. Pelilauta luodaan MineSweeperGame luokassa. Peli luokka huolehtii laudan ja käyttöliittymän alustamisesta käyttäjän antaman koon mukaan.
Grafiikka puolella UserInterface huolehtii koko käyttöliittymän rakentamisesta. ButtonMOuseListener puolestaan huolehtii hiiren painallusten rekisteröinnistä ja buttonien maalasimesta ja näyttämisestä.

**Käyttöohje**

Peli on miinaharava. Pelin aluksi voit valita halutun koon kentälle. Small = 5x5, Medium = 10x10, Large = 15x15. Pelin voittaminen vaatii kaikkien ei pommillisten ruutujen paljastamista.
