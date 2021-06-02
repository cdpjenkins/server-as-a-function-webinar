package com.example

import org.http4k.chaos.Behaviour
import org.http4k.chaos.ChaosEngine
import org.http4k.core.HttpHandler
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.then
import org.http4k.server.SunHttp
import org.http4k.server.asServer

/**
 * Simple in-memory version of the PokemonAPI. Because it is
 * an HttpHandler, we can launch it as a Server!
 */
fun main() {
    FakePokemonApi().asServer(SunHttp(8000)).start()
}

/**
 * Returns hardcoded content by default, but we could also use lenses
 * and the PokemonAPI model.
 *
 * We have enhanced the fake here with the ChaosEngine filter which
 * allows us to easily simulate failures (see the FakePokemonAPI test).
 */
class FakePokemonApi : HttpHandler {

    private val engine = ChaosEngine()

    fun enableChaos(behaviour: Behaviour) = engine.enable(behaviour)

    override fun invoke(req: Request) = engine.then(defaultBehaviour)(req)

    private val defaultBehaviour: HttpHandler = {
        Response(OK)
            .header("""access-control-allow-origin""", """*""")
            .header(
                """alt-svc""", """h3-27=":443"; ma=86400, h3-28=":443"; ma=86400, h3-29=":443"; ma=86400,
        h3=":443"; ma=86400"""
            )
            .header("""cache-control""", """public, max-age=86400, s-maxage=86400""")
            .header("""cf-cache-status""", """REVALIDATED""")
            .header("""cf-ray""", """65d504965a1b4090-LHR""")
            .header("""cf-request-id""", """0a990131f60000409009173000000001""")
            .header("""connection""", """keep-alive""")
            .header("""content-type""", """application/json; charset=utf-8""")
            .header("""date""", """Thu, 10 Jun 2021 19:31:06 GMT""")
            .header("""etag""", """W/"19ec-8/wsp3EfczGnBIxYH58C7cYqKDI""")
            .header(
                """expect-ct""", """max-age=604800,
        report-uri="https://report-uri.cloudflare.com/cdn-cgi/beacon/expect-ct"""
            )
            .header("""function-execution-id""", """l4ozcwgnpr49""")
            .header("""nel""", """{"report_to":"cf-nel","max_age":604800}""")
            .header(
                """report-to""",
                """{"endpoints":[{"url":"https:\/\/a.nel.cloudflare.com\/report\/v2?s=1h3%2BF%2BoPoSsrL3yLK1pX75KGD7TxxlGp2HzKi8oWnoezAAGRx%2FxeXfzsLVFMDZYH2%2BbgrWvd0Np2ofyc655j98fvpKySeEF6PbFdYx6r7XcLXFXJ%2FZxi%2FA%3D%3D"}],"group":"cf-nel","max_age":604800}"""
            )
            .header("""server""", """cloudflare""")
            .header("""transfer-encoding""", """chunked""")
            .header(
                """vary""", """Accept-Encoding,cookie,need-authorization, x-fh-requested-host,
        accept-encoding"""
            )
            .header("""x-cache""", """HIT""")
            .header("""x-cache-hits""", """1""")
            .header("""x-cloud-trace-context""", """7901e238ef11c276bda5ecf47ed91af4""")
            .header("""x-country-code""", """GB""")
            .header("""x-orig-accept-language""", """he,en-US;q=0.9,en;q=0.8,ru;q=0.7""")
            .header("""x-powered-by""", """Express""")
            .header("""x-served-by""", """cache-lon4266-LON""")
            .header("""x-timer""", """S1623000469.142543,VS0,VE1""")
            .body(
                """{"count":1118,"next":"https://pokeapi.co/api/v2/pokemon?offset=100&limit=100","previous":null,"results":[{"name":"bulbasaur","url":"https://pokeapi.co/api/v2/pokemon/1/"},{"name":"ivysaur","url":"https://pokeapi.co/api/v2/pokemon/2/"},{"name":"venusaur","url":"https://pokeapi.co/api/v2/pokemon/3/"},{"name":"charmander","url":"https://pokeapi.co/api/v2/pokemon/4/"},{"name":"charmeleon","url":"https://pokeapi.co/api/v2/pokemon/5/"},{"name":"charizard","url":"https://pokeapi.co/api/v2/pokemon/6/"},{"name":"squirtle","url":"https://pokeapi.co/api/v2/pokemon/7/"},{"name":"wartortle","url":"https://pokeapi.co/api/v2/pokemon/8/"},{"name":"blastoise","url":"https://pokeapi.co/api/v2/pokemon/9/"},{"name":"caterpie","url":"https://pokeapi.co/api/v2/pokemon/10/"},{"name":"metapod","url":"https://pokeapi.co/api/v2/pokemon/11/"},{"name":"butterfree","url":"https://pokeapi.co/api/v2/pokemon/12/"},{"name":"weedle","url":"https://pokeapi.co/api/v2/pokemon/13/"},{"name":"kakuna","url":"https://pokeapi.co/api/v2/pokemon/14/"},{"name":"beedrill","url":"https://pokeapi.co/api/v2/pokemon/15/"},{"name":"pidgey","url":"https://pokeapi.co/api/v2/pokemon/16/"},{"name":"pidgeotto","url":"https://pokeapi.co/api/v2/pokemon/17/"},{"name":"pidgeot","url":"https://pokeapi.co/api/v2/pokemon/18/"},{"name":"rattata","url":"https://pokeapi.co/api/v2/pokemon/19/"},{"name":"raticate","url":"https://pokeapi.co/api/v2/pokemon/20/"},{"name":"spearow","url":"https://pokeapi.co/api/v2/pokemon/21/"},{"name":"fearow","url":"https://pokeapi.co/api/v2/pokemon/22/"},{"name":"ekans","url":"https://pokeapi.co/api/v2/pokemon/23/"},{"name":"arbok","url":"https://pokeapi.co/api/v2/pokemon/24/"},{"name":"pikachu","url":"https://pokeapi.co/api/v2/pokemon/25/"},{"name":"raichu","url":"https://pokeapi.co/api/v2/pokemon/26/"},{"name":"sandshrew","url":"https://pokeapi.co/api/v2/pokemon/27/"},{"name":"sandslash","url":"https://pokeapi.co/api/v2/pokemon/28/"},{"name":"nidoran-f","url":"https://pokeapi.co/api/v2/pokemon/29/"},{"name":"nidorina","url":"https://pokeapi.co/api/v2/pokemon/30/"},{"name":"nidoqueen","url":"https://pokeapi.co/api/v2/pokemon/31/"},{"name":"nidoran-m","url":"https://pokeapi.co/api/v2/pokemon/32/"},{"name":"nidorino","url":"https://pokeapi.co/api/v2/pokemon/33/"},{"name":"nidoking","url":"https://pokeapi.co/api/v2/pokemon/34/"},{"name":"clefairy","url":"https://pokeapi.co/api/v2/pokemon/35/"},{"name":"clefable","url":"https://pokeapi.co/api/v2/pokemon/36/"},{"name":"vulpix","url":"https://pokeapi.co/api/v2/pokemon/37/"},{"name":"ninetales","url":"https://pokeapi.co/api/v2/pokemon/38/"},{"name":"jigglypuff","url":"https://pokeapi.co/api/v2/pokemon/39/"},{"name":"wigglytuff","url":"https://pokeapi.co/api/v2/pokemon/40/"},{"name":"zubat","url":"https://pokeapi.co/api/v2/pokemon/41/"},{"name":"golbat","url":"https://pokeapi.co/api/v2/pokemon/42/"},{"name":"oddish","url":"https://pokeapi.co/api/v2/pokemon/43/"},{"name":"gloom","url":"https://pokeapi.co/api/v2/pokemon/44/"},{"name":"vileplume","url":"https://pokeapi.co/api/v2/pokemon/45/"},{"name":"paras","url":"https://pokeapi.co/api/v2/pokemon/46/"},{"name":"parasect","url":"https://pokeapi.co/api/v2/pokemon/47/"},{"name":"venonat","url":"https://pokeapi.co/api/v2/pokemon/48/"},{"name":"venomoth","url":"https://pokeapi.co/api/v2/pokemon/49/"},{"name":"diglett","url":"https://pokeapi.co/api/v2/pokemon/50/"},{"name":"dugtrio","url":"https://pokeapi.co/api/v2/pokemon/51/"},{"name":"meowth","url":"https://pokeapi.co/api/v2/pokemon/52/"},{"name":"persian","url":"https://pokeapi.co/api/v2/pokemon/53/"},{"name":"psyduck","url":"https://pokeapi.co/api/v2/pokemon/54/"},{"name":"golduck","url":"https://pokeapi.co/api/v2/pokemon/55/"},{"name":"mankey","url":"https://pokeapi.co/api/v2/pokemon/56/"},{"name":"primeape","url":"https://pokeapi.co/api/v2/pokemon/57/"},{"name":"growlithe","url":"https://pokeapi.co/api/v2/pokemon/58/"},{"name":"arcanine","url":"https://pokeapi.co/api/v2/pokemon/59/"},{"name":"poliwag","url":"https://pokeapi.co/api/v2/pokemon/60/"},{"name":"poliwhirl","url":"https://pokeapi.co/api/v2/pokemon/61/"},{"name":"poliwrath","url":"https://pokeapi.co/api/v2/pokemon/62/"},{"name":"abra","url":"https://pokeapi.co/api/v2/pokemon/63/"},{"name":"kadabra","url":"https://pokeapi.co/api/v2/pokemon/64/"},{"name":"alakazam","url":"https://pokeapi.co/api/v2/pokemon/65/"},{"name":"machop","url":"https://pokeapi.co/api/v2/pokemon/66/"},{"name":"machoke","url":"https://pokeapi.co/api/v2/pokemon/67/"},{"name":"machamp","url":"https://pokeapi.co/api/v2/pokemon/68/"},{"name":"bellsprout","url":"https://pokeapi.co/api/v2/pokemon/69/"},{"name":"weepinbell","url":"https://pokeapi.co/api/v2/pokemon/70/"},{"name":"victreebel","url":"https://pokeapi.co/api/v2/pokemon/71/"},{"name":"tentacool","url":"https://pokeapi.co/api/v2/pokemon/72/"},{"name":"tentacruel","url":"https://pokeapi.co/api/v2/pokemon/73/"},{"name":"geodude","url":"https://pokeapi.co/api/v2/pokemon/74/"},{"name":"graveler","url":"https://pokeapi.co/api/v2/pokemon/75/"},{"name":"golem","url":"https://pokeapi.co/api/v2/pokemon/76/"},{"name":"ponyta","url":"https://pokeapi.co/api/v2/pokemon/77/"},{"name":"rapidash","url":"https://pokeapi.co/api/v2/pokemon/78/"},{"name":"slowpoke","url":"https://pokeapi.co/api/v2/pokemon/79/"},{"name":"slowbro","url":"https://pokeapi.co/api/v2/pokemon/80/"},{"name":"magnemite","url":"https://pokeapi.co/api/v2/pokemon/81/"},{"name":"magneton","url":"https://pokeapi.co/api/v2/pokemon/82/"},{"name":"farfetchd","url":"https://pokeapi.co/api/v2/pokemon/83/"},{"name":"doduo","url":"https://pokeapi.co/api/v2/pokemon/84/"},{"name":"dodrio","url":"https://pokeapi.co/api/v2/pokemon/85/"},{"name":"seel","url":"https://pokeapi.co/api/v2/pokemon/86/"},{"name":"dewgong","url":"https://pokeapi.co/api/v2/pokemon/87/"},{"name":"grimer","url":"https://pokeapi.co/api/v2/pokemon/88/"},{"name":"muk","url":"https://pokeapi.co/api/v2/pokemon/89/"},{"name":"shellder","url":"https://pokeapi.co/api/v2/pokemon/90/"},{"name":"cloyster","url":"https://pokeapi.co/api/v2/pokemon/91/"},{"name":"gastly","url":"https://pokeapi.co/api/v2/pokemon/92/"},{"name":"haunter","url":"https://pokeapi.co/api/v2/pokemon/93/"},{"name":"gengar","url":"https://pokeapi.co/api/v2/pokemon/94/"},{"name":"onix","url":"https://pokeapi.co/api/v2/pokemon/95/"},{"name":"drowzee","url":"https://pokeapi.co/api/v2/pokemon/96/"},{"name":"hypno","url":"https://pokeapi.co/api/v2/pokemon/97/"},{"name":"krabby","url":"https://pokeapi.co/api/v2/pokemon/98/"},{"name":"kingler","url":"https://pokeapi.co/api/v2/pokemon/99/"},{"name":"voltorb","url":"https://pokeapi.co/api/v2/pokemon/100/"}]}"""
            )
    }
}
