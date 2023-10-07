import requests
from bs4 import BeautifulSoup
import csv  

# Recuperer les donnees automatiquement sur le web
def recuperer_donnees(terme):
  url = 'http://jeuxdemots.org/rezo-dump.php?gotermsubmit=Chercher&gotermrel='+terme+'&rel='
  r = requests.get(url)
  soup = BeautifulSoup(r.content, 'html.parser')
  code = soup.find_all("code")
  return code

# Sauver les donnees dans un fichier
def sauver_donnees(nom_fichier, code_a_sauvegarder):
  with open(nom_fichier, "w") as f:
    for c in code_a_sauvegarder:
        f.write(c.text)

code = recuperer_donnees("chat")
sauver_donnees("code_chat.txt", code)

def parser_txt_to_csv(fichier_entree, fichier_sortie):

  # Ouvrir le fichier texte en mode lecture
  with open(fichier_entree, 'r') as input_file:
      # Ouvrir le fichier CSV en mode écriture
      with open(fichier_sortie, 'w', newline='') as output_file:
          # Créer l'objet writer CSV
          writer = csv.writer(output_file)

          # Écrire l'en-tête du fichier CSV
          writer.writerow(['nom', 'id', 'name_ou_node1', 'name_ou_node2', 'type', 'w'])

          # Boucle sur chaque ligne du fichier texte
          for line in input_file:
              # Vérifier si la ligne correspond à l'un des formats souhaités
              if line.startswith('nt;'):
                  # Format 1 : nt; ntid; 'ntname'
                  nom = 'nt'
                  id_, name_ou_node1 = line.split(';')[1:3]
                  name_ou_node2, type_, w = '', '', ''

              elif line.startswith('e;'):
                  # Format 2 : e; eid; 'name'; type; w; 'formated name'
                  nom = 'e'
                  if len(line.split(';'))==6:
                    id_, name_ou_node1, type_, w, name_ou_node2 = line.split(';')[1:6]
                  else:
                    id_, name_ou_node1, type_, w = line.split(';')[1:5]
                    name_ou_node2 = ''

              elif line.startswith('rt;'):
                  # Format 3 : rt; rtid; 'trname'; 'trgpname'; 'rthelp'
                  nom = 'rt'
                  id_, name_ou_node1, name_ou_node2, type_ = line.split(';')[1:5]
                  w = ''

              elif line.startswith('r;'):
                  # Format 4 : r; rid; node1; node2; type; w
                  nom = 'r'
                  id_, node1, node2, type_, w = line.split(';')[1:6]
                  name_ou_node1, name_ou_node2, type_ = node1, node2, type_

              else:
                  # Ignorer les lignes qui ne correspondent pas aux formats souhaités
                  continue

              # Écrire les informations dans le fichier CSV
              writer.writerow([nom, id_, name_ou_node1.strip("'"), name_ou_node2.strip("'"), type_, w])

parser_txt_to_csv("code_chat.txt", "code_chat.csv")