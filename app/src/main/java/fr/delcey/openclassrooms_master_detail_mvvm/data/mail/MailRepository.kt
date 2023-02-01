package fr.delcey.openclassrooms_master_detail_mvvm.data.mail

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MailRepository @Inject constructor() {

    private val emailsMutableStateFlow: MutableStateFlow<List<MailEntity>> = MutableStateFlow(
        listOf(
            MailEntity(
                id = "0",
                title = "RE: Ma liste au père Noël",
                message = "Tu as été très vilain, tu n'auras rien ! \n\nOriginal message: \n> Je veux une licorne, une baguette magique et un BMX. Merci Papa Noël !",
                from = "papa@noël.com",
                to = listOf("nino@delcey.fr")
            ),
            MailEntity(
                id = "1",
                title = "Bonne année !",
                message = "Bonne année, <insérer une réplique de film ou un diction pourri>",
                from = "unmecquejeconnaispas@wtf.com",
                to = listOf(
                    "famille@delcey.fr",
                    "famille@bis.com",
                    "genretoutlemonde@world.com",
                    "random@stuff.net",
                    "cousinsjamaisrencontrés@unknown.com"
                )
            ),
            MailEntity(
                id = "2",
                title = "OC: Projet 9 validé",
                message = "Bravo, votre étudiant Jean-Jacques DUJARDINGUE a validé son projet 9. \n" +
                    "Commentaires de l'équipe: Il aurait mieux fallu utiliser Java que Kotlin. C'est trop neuf Kotlin voyons, c'est juste un effet de mode si tout le monde l'utilise.",
                from = "noreply@OC.com",
                to = listOf("jj.dujardingue@nice.com", "nino@delcey.fr")
            )
        )
    )
    val emailsStateFlow: StateFlow<List<MailEntity>> = emailsMutableStateFlow.asStateFlow()

    fun getMailById(id: String): MailEntity? = emailsMutableStateFlow.value.find { it.id == id }
}