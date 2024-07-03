package school.hei.patrimoine.modele;

import org.junit.jupiter.api.Test;
import school.hei.patrimoine.modele.possession.Argent;
import school.hei.patrimoine.modele.possession.FluxArgent;
import school.hei.patrimoine.modele.possession.Materiel;

import java.time.LocalDate;
import java.util.Set;

import static java.time.Month.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatrimoineZetyTest {
    @Test
    void patrimoine_vaut_0() {
        var zety = new Personne("Zety");
        var patrimoineZetyAu17sept24 = new Patrimoine("patrimoineDeZetyAu17sept24",
                zety,
                LocalDate.of(2024, SEPTEMBER,17),
                Set.of());
        assertEquals(0, patrimoineZetyAu17sept24.getValeurComptable());
    }
    @Test
    void patrimoine_de_Zety_au_17_septembre_2024() {
        var zety = new Personne("Zety");

        var au3jul24 = LocalDate.of(2024, JULY, 3);

        var ordinateur = new Materiel(
                "Ordinateur",
                au3jul24,
                1_200_000,
                au3jul24,
                -0.10);

        var vetements = new Materiel(
                "Vêtements",
                au3jul24,
                1_500_000,
                au3jul24,
                -0.50);

        var argentEspeces = new Argent(
                "Espèces",
                au3jul24,
                800_000);

        var debutFraisScolarite = LocalDate.of(2023, NOVEMBER, 27);
        var finFraisScolarite = LocalDate.of(2024, AUGUST, 27);
        var fraisScolarite = new FluxArgent(
                "Frais de scolarité",
                argentEspeces,
                debutFraisScolarite,
                finFraisScolarite,
                200_000,
                27);

        var compteBancaire = new Argent(
                "Compte Bancaire",
                au3jul24,
                100_000);

        var debutCompteBancaire = LocalDate.of(2024, JULY, 25);
        var fraisCompteBancaire = new FluxArgent(
                "Frais de tenue de compte",
                compteBancaire,
                debutCompteBancaire,
                LocalDate.MAX,
                -20_000,
                25);

        var patrimoineZetyAu17sept24 = new Patrimoine(
                "patrimoineZetyAu17sept24",
                zety,
                au3jul24,
                Set.of(
                        ordinateur,
                        vetements,
                        argentEspeces,
                        compteBancaire,
                        fraisScolarite,
                        fraisCompteBancaire
                )
        );

        assertEquals(3600000.0, patrimoineZetyAu17sept24.getValeurComptable());
    }
}
