# Sistem za upravljanje inženjerskim projektima i automatizacijom (Automatikom Management System)

Ovaj projekat predstavlja prvu fazu (PZ01) projektnog zadatka iz predmeta **IT355 - Veb sistemi 2** na Metropolitan univerzitetu. Aplikacija služi za evidenciju i upravljanje resursima u inženjerskim projektima industrijske automatizacije.

## Opis Sistema
**Automatikom Management System** je veb aplikacija koja olakšava organizaciju inženjerskih projekata. Omogućava:
- Evidenciju hardverskih komponenti (PLC-ovi, HMI paneli, frekventni regulatori).
- Praćenje softverskih licenci (TIA Portal, WinCC Runtime, WinCC OA).
- Upravljanje inženjerskim timom (PLC programeri, SCADA inženjeri, projektanti).
- Dodelu i praćenje konkretnih zadataka po projektima i inženjerima.

## Arhitektura (PZ01)
Aplikacija je implementirana u **Spring Boot 4.0.6 (Java 21)** frejmworku prateći čist **MVC (Model-View-Controller)** arhitekturni šablon:
- **Model sloj (POJO)**: Predstavlja podatke u sistemu.
- **Repository sloj (InMemoryRepository)**: Simulira bazu podataka. Pošto u prvoj fazi projekta ne koristimo eksternu bazu, podaci se čuvaju in-memory u radnoj memoriji aplikacije kao Spring singleton bean (Application Scope), sa logikom za automatsko dodeljivanje jedinstvenih ID-jeva.
- **Service sloj (AutomatizacijaService)**: Sloj poslovne logike koji povezuje repozitorijume sa kontrolerima.
- **Controller sloj (Spring MVC Kontroleri)**: Prihvata zahteve i prosleđuje ih odgovarajućim Thymeleaf šablonima.
- **View sloj (Thymeleaf & CSS)**: Dinamički HTML šabloni stilizovani modernom tamnom "clean-tech" dashboard temom (čist CSS).

## Struktura klasa
Sistem je modelovan kroz sledećih 5 model klasa (POJO):
1. **Projekat**: `id`, `naziv`, `klijent`, `status`
2. **Komponenta**: `id`, `naziv`, `serijskiBroj`, `proizvodjac`, `status`
3. **Inzenjer**: `id`, `ime`, `prezime`, `email`, `uloga`
4. **Licenca**: `id`, `nazivSoftvera`, `kljucLicence`, `tipLicence`, `aktivna`
5. **Zadatak**: `id`, `opis`, `projekatId`, `inzenjerId`, `zavrsen`

## Uputstvo za pokretanje
Da biste pokrenuli aplikaciju lokalno, pratite sledeće korake:

1. Klonirajte repozitorijum.
2. Otvorite korenski direktorijum projekta.
3. Pokrenite server komandom:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Aplikaciju možete otvoriti u pretraživaču na adresi:
   [http://localhost:8080](http://localhost:8080)

## Uputstvo za korišćenje

### Početna strana (Dashboard)
Nakon pokretanja, otvorite `http://localhost:8080` u pretraživaču. Prikazuje se početna strana sa navigacijom do svih modula sistema. Navigacioni meni se nalazi na vrhu svake strane i sadrži linkove: **Projekti**, **Komponente**, **Inženjeri**, **Licence**, **Zadaci**.

---

### Upravljanje projektima (`/projekti`)
| Akcija | Opis |
|---|---|
| Pregled liste | Kliknite **Projekti** u navigaciji — prikazuje se tabela sa svim projektima (naziv, klijent, status). |
| Dodavanje | Kliknite dugme **Novi projekat**, popunite formu (naziv, klijent, status) i kliknite **Sačuvaj**. |
| Izmena | U tabeli, kliknite **Izmeni** pored željenog projekta, izmenite polja i sačuvajte. |
| Brisanje | U tabeli, kliknite **Obriši** pored željenog projekta. Brisanje je trenutno bez potvrde. |

---

### Upravljanje komponentama (`/komponente`)
| Akcija | Opis |
|---|---|
| Pregled liste | Kliknite **Komponente** u navigaciji — prikazuje se tabela (naziv, serijski broj, proizvođač, status). |
| Dodavanje | Kliknite **Nova komponenta**, popunite formu i sačuvajte. |
| Izmena | Kliknite **Izmeni** pored komponente, izmenite i sačuvajte. |
| Brisanje | Kliknite **Obriši** pored komponente. |

---

### Upravljanje inženjerima (`/inzenjeri`)
| Akcija | Opis |
|---|---|
| Pregled liste | Kliknite **Inženjeri** — tabela prikazuje ime, prezime, email i ulogu svakog inženjera. |
| Dodavanje | Kliknite **Novi inženjer**, unesite podatke (ime, prezime, email, uloga) i sačuvajte. |
| Izmena | Kliknite **Izmeni**, izmenite podatke i sačuvajte. |
| Brisanje | Kliknite **Obriši** pored inženjera. |

---

### Upravljanje licencama (`/licence`)
| Akcija | Opis |
|---|---|
| Pregled liste | Kliknite **Licence** — tabela prikazuje naziv softvera, ključ licence, tip i status aktivnosti. |
| Dodavanje | Kliknite **Nova licenca**, unesite naziv softvera, ključ, tip i da li je aktivna, zatim sačuvajte. |
| Izmena | Kliknite **Izmeni**, izmenite i sačuvajte. |
| Brisanje | Kliknite **Obriši** pored licence. |

---

### Upravljanje zadacima (`/zadaci`)
| Akcija | Opis |
|---|---|
| Pregled liste | Kliknite **Zadaci** — tabela prikazuje opis zadatka, naziv projekta, ime inženjera i status završenosti. |
| Dodavanje | Kliknite **Novi zadatak**, unesite opis, izaberite projekat i inženjera iz padajućih listi, označite da li je završen i sačuvajte. |
| Izmena | Kliknite **Izmeni**, izmenite podatke i sačuvajte. |
| Brisanje | Kliknite **Obriši** pored zadatka. |

---

### Napomena o podacima
Aplikacija se pokreće sa unapred učitanim test-podacima (3 inženjera, 2 projekta, 3 komponente, 2 licence, 3 zadatka). Svi podaci se čuvaju u memoriji aplikacije (`@ApplicationScope`) i resetuju se pri svakom ponovnom pokretanju servera.
