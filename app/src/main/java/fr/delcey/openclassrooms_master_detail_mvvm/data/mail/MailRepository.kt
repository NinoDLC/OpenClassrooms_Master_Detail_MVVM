package fr.delcey.openclassrooms_master_detail_mvvm.data.mail

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MailRepository @Inject constructor() {

    private val emailsFlow = flowOf(
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

    fun getAllMailFlow(): Flow<List<MailEntity>> = emailsFlow

    fun getMailByIdFlow(id: String): Flow<MailEntity> = emailsFlow.map { mails ->
        mails.first { it.id == id }
    }
}