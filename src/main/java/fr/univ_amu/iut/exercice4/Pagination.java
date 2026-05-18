package fr.univ_amu.iut.exercice4;

/// Kata 4 - Pagination.
///
/// Kata algorithmique avec beaucoup de cas limites. Idéal pour pratiquer la
/// **discipline TDD** : on active les tests dans l'ordre (du plus simple au plus
/// complexe) et on résiste à la tentation d'anticiper.
public class Pagination {

  private final int courant;
  private final int total;

  public Pagination(int courant, int total) {
    this.courant = courant;
    this.total = total;
  }

  // Debut des fonctions :
  private String siAffiche() {
    String result = "";
    for (int i = 0; i < total; i++) {
      if (i + 1 == courant) result += "(" + courant + ")";
      else result += i + 1;
      if (i + 1 < total) result += " ";
    }
    return result;
  }

  private String petit() {
    if (courant - 1 == 1) return "1 (2) 3 ... " + total;
    else return "1 2 (3) 4 ... " + total;
  }

  private String grand() {
    if (courant + 1 == total) return "1 ... 13 (14) 15";
    else return "1 ... 12 (13) 14 15";
  }

  private String sinonAffiche() {
    if (courant - 2 == 1 || courant - 1 == 1 || courant + 1 == total || courant + 2 == total) {
      return (courant - 2 == 1 || courant - 1 == 1) ? petit() : grand();
    } else {
      return "1"
          + " ... "
          + (courant - 1)
          + " ("
          + courant
          + ") "
          + (courant + 1)
          + " ... "
          + total;
    }
  }

  private String verifiePaginationTaille() {
    return (total <= 7) ? siAffiche() : sinonAffiche();
  }

  /// Retourne la représentation textuelle de la barre de pagination.
  ///
  /// Format : pages séparées par des espaces, page courante entre parenthèses,
  /// `...` pour combler les trous quand il y a plus de 7 pages au total.
  public String afficher() {
    // TODO kata 4 : construire la chaîne de pagination selon les règles
    // du README. Activez les tests dans l'ordre ils vous guident :
    // - d'abord le cas "total <= 7" (affichage complet)
    // - puis le cas "beaucoup de pages" avec gestion des ellipses
    return verifiePaginationTaille();
  }
}
