package tap

import java.util.UUID
import scala.util.Try

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("known blue player") {
    val uuid: UUID = UUID.randomUUID()

    val player = Player(uuid,  "Foo")
    val state: GameState.Started = GameState.Started(blueTeam = List(player), redTeam = Nil, 0, "", Color(0, 0, 0))

    assert(GameRules.playerTeam(uuid, state) == Team.Blue)
  }

  test("known red player") {
    val uuid: UUID = UUID.randomUUID()

    val player = Player(uuid,  "Foo")
    val state: GameState.Started = GameState.Started(blueTeam = Nil, redTeam = List(player), 0, "", Color(0, 0, 0))

    assert(GameRules.playerTeam(uuid, state) == Team.Red)
  }

  test("unknown player") {
    val uuid: UUID = UUID.randomUUID()

    val player = Player(uuid,  "Foo")
    val state: GameState.Started = GameState.Started(blueTeam = Nil, redTeam = Nil, 0, "", Color(0, 0, 0))

    val result = Try(GameRules.playerTeam(uuid, state))
    assert(result.isFailure)
    assert(result.failed.get.getMessage == "an implementation is missing")
  }

  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
}
