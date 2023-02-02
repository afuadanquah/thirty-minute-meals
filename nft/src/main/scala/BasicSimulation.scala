
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.concurrent.duration.{DurationDouble, DurationInt}
import scala.language.postfixOps

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080/thirty-min-meals/recipe").
    check(status.is(200))

  val scn = scenario("BasicSimulation")
    .exec(http("GetRecipe1")
      .get("/1"))
    .pause(5)

  setUp(
    scn.inject(
      constantUsersPerSec(10).during(5))).throttle(
    reachRps(10) in (30 seconds),
    holdFor(4.5 minutes),
    reachRps(0) in (30 seconds)
  ).protocols(httpProtocol)
    .assertions(
      global.successfulRequests.percent.gte(99),
      global.responseTime.max.lte(3000)
    )


}
