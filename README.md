# Sprawozdanie z Laboratorium: Lokalizacja aplikacji

## Zadanie 1: Zasoby tekstowe i parametryzacja
- **Jak usunięto teksty z kodu?** Zastąpiono ciągi znaków funkcją `stringResource(id = R.string...)`.
- **Jak zrealizowano powitanie z parametrami?** Użyto argumentów pozycyjnych (`%1$s`, `%2$d`) w pliku `strings.xml` i przekazano wartości w kodzie.

## Zadanie 2: Tablica żartów i losowanie (`string-array`)
- **Jak zaimplementowano zasób zbiorczy?** Utworzono element `<string-array>` w plikach `strings.xml`.
- **Jak zrealizowano losowanie w kodzie?** Użyto `stringArrayResource` oraz metody `.random()`.

## Zadanie 3: Liczba mnoga (`plurals`)
- **Jak obsłużono liczbę mnogą?** Zastąpiono instrukcje warunkowe tagami `<plurals>`.
- **Czym różni się wersja polska od angielskiej?** Angielski ma 2 formy (`one`, `other`), a polski 4 formy zgodne z CLDR (`one`, `few`, `many`, `other`).
- **Jak pobrać plurals w kodzie?** Użyto `pluralStringResource`, podając licznik dwukrotnie (jako `count` oraz wartość `%d`).

## Zadanie 4: Natywna zmiana języka
- **Jak skonfigurowano obsługę języków?** Dodano plik `locales_config.xml` i powiązano go w `AndroidManifest.xml` (`android:localeConfig`).
- **Dlaczego wybrano API 33 (`LocaleManager`)?** Umożliwia to natywną zmianę języka w locie z poziomu aplikacji bez dodatkowych bibliotek.

## Zadanie 5: Test gotowości na tłumaczenie
- **Jak włączono pseudojęzyki?** Dodano `isPseudoLocalesEnabled = true` w pliku `build.gradle.kts`.
- **Do czego służą pseudojęzyki (`en-XA`)?** Do testowania interfejsu przy sztucznie wydłużonych tekstach i wykrywania błędów UI.
