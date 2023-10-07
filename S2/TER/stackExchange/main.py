import requests

# Remplacer les valeurs suivantes par vos propres informations d'identification de l'API Stack Exchange
STACK_EXCHANGE_KEY = "votre_clé_API"
STACK_EXCHANGE_SITE = "stackoverflow"

# Requête pour récupérer les questions liées à Android Studio avec le tag "android-studio"
response = requests.get(f"https://api.stackexchange.com/2.3/questions?pagesize=100&order=desc&sort=activity&tagged=android-studio&site={STACK_EXCHANGE_SITE}")

# Vérifier que la requête s'est bien passée (status_code = 200)
if response.status_code == 200:
    # Récupérer les données au format JSON
    data = response.json()
    # Parcourir les questions et afficher les titres
    for question in data["items"]:
        print(question["title"])
else:
    print("Erreur lors de la requête :", response.status_code)