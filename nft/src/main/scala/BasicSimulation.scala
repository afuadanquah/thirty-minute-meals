
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  //Simple NFT test

  val httpProtocol = http
    .baseUrl("http://localhost:8080/thirty-min-meals/recipe")

  val scn = scenario("BasicSimulation")
    .exec(http("GetRecipe1")
      .get("/1"))
    .pause(5)

  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpProtocol)

}
