  

## Notes pour la réunion du 07-02


### ADB:
 Est un outil en ligne de commande qui permet de communiqué avec un appareil Android connécté sur l'ordinateur pour exécuter diverses tâches, telles que la vérification des logs la et la modification des paramètres système.

>Il s'agit d'un **programme client-serveur** qui comprend :
>**Un client :** qui s'exécute sur l'ordinateur et qui envoie des commandes.
>**Un deamon:** qui s'exécute sur un appareil en arrière-plan et qui exécute les commandes.
>**Un serveur:** qui s'exécute en arrière-plan sur l'odinateur et qui gère la communication entre le client et le deamon

 [Utilisation de ADB](https://developer.android.com/studio/command-line/adb?hl=fr#directingcommands)

Donc ADB est plus un outils pour envoyer des commandes depuis l'environnement de développement vers l'appreil andoid où le deamon les exécuteras sur l'appareil. On peut en déduire qu'il nous est pas très utile. J'ai donc pu confirmer cela avec ChatGPT en lui demandant *ADB peut-il enregistrer des traces qui comportent toutes les modifications apportées par le développeur sur Android studio, par exemple chaque clique de la souris ."*, il m'as donc répondu que ce n'était pas possible.


Les autres solutions serait d'utiliser une bibliothèque de journalisation ou bien utiliser des bibliothèques comme ACRA pour générer des traces de développement

### ACRA
ACRA (Application Crash Reporter for Android) permet de collecter des informations détaillées sur les erreurs et les exceptions qui se produisent dans l'application. Ce n'est pas donc ce qu'on cherche.

### Les bibliothèques de journalisation :
D'après ChatGPT il y aurait une autre solution, utiliser une bibliothèque de journalisation comme **Timber**, **Logback**, **Log4j** ou bien **Slf4j**. Ces bibliothèques nous permettrait peut-être de pouvoir enregistrer des traces contenant les modifications apportées par le développeur dans Android Studio, telles que les clics de souris, les erreurs et les modifications apportées au code.

Cependant, elles ne sont pas conçues pour enregistrer automatiquement toutes les modifications faites par le développeur dans Android Studio, telles que chaque clic de souris. Une intervention et donc probablement nécessaire pour implémenter  cette fonctionnalité en utilisant ces bibliothèques, ce qui n'est pas très pratique. C'est donc une option de dernier recours, si bien sur il n'y a pas mieux.

Parmi les biblitohèques de journalisation, il y a **Logback** qui pourrait nous être utile, mais il faut développer soit même une solution en utilisant les fonctionnalités de journalisation de Logback, et cela peut s'avérer complexe et requèrir un développement important pour atteindre les fonctionnalités souhaité.

**Logback:** Logback est un framework de journalisation pour les applications Java. Il est considéré comme une évolution de la bibliothèque de journalisation Log4j et offre de nombreuses fonctionnalités supplémentaires telles que des performances améliorées, une configuration plus souple et des capacités de journalisation plus avancées.
 


Une autre solution serais d'utiliser des outils d'audit d'IDE ou bien la création de plugin pour Andoid studio.

### Intellij Platform API

**Intellij Platform API** est une plateforme de développement logiciel open source qui fournit une API pour la création d'IDE (Integrated Development Environment) pour Java et d'autres langages de programmation. Il est largement utilisé pour le développement de plugins pour les produits IntelliJ.  Il est donc possible, en utlisant l'API, de créer des plugins qui s'intègrent aux fonctionnalités d'Android Studio et ainsi pouvoir générer des traces grâce à ces plusgins

C'est un ensemble d'API's et de bibliothèques qui servent à développer des plugins, elles offrents un accés aux fonctionnalités de la platforme **IntelliJ**, telles que la gestion du code, la mise en surbillance du texte, la vérification du code, l'autocomplétion du code, la reconnaissance de la syntaxe, la navigation dans le code etc.. **Elles fournissent également un accés à l'interface utilisateur**, telles que les boites de dialogue, les menus, les barres d'outils etc.

On peut également **recevoir des alertes ou des notifications pour des évènements spécifique**, par example la fermeture d'un fichier, la modification du code donc il peut certainement être configuré pour recevoir une alerte dès qu'une erreur liée à l'environnement est détectée. Ainsi, le plugin pourras effectuer des actions en réponse à ces alertes telles que **la collecte des modifications apportées par le développeur ainsi que la génération de traces.** 

[Getting Started](https://plugins.jetbrains.com/docs/intellij/plugins-quick-start.html)


Quels sont les actions pertinantes qui peuvent servirent à la correction de beugue automatique ?
Lire des acrticles sur l'apprentissage automatique d





