# Bouncedown Leikur

JavaFX leikur þar sem leikmaður stýrir bolta sem fellur niður skjáinn (verkefni í HBV201G 2023).


## Virkni leiksins

- Boltinn fellur sjálfkrafa niður skjáinn
- Leikmaður getur stýrt boltanum til hægri og vinstri með örvatakkana 
- Pallar birtast af handahófi á skjánum
- Leikmaður þarf að láta boltann lenda á pöllunum til að komast áfram
- Ef boltinn fer út af skjánum að neðan þá tapar leikmaður

## Stýringar

- Vinstri örvatakki: Færir boltann til vinstri
- Hægri örvatakki: Færir boltann til hægri

##

Leikurinn er byggður með:
- Java 11
- JavaFX 17.0.2
- Maven

### Keyrsla leiksins

Til að keyra leikinn:

1. Java 11+
2. Notaðu Maven til að keyra leikinn:
   ```
   mvn clean javafx:run
   ```
