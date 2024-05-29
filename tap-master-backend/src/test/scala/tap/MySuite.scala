package tap

import java.util.UUID

// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  test("known blue player") {
    val uuid: UUID = UUID.randomUUID()

    val player = Player(uuid,  "Foo")
    val state: GameState.Started = GameState.Started(blueTeam = List(player), redTeam = Nil, 0, "", Color(0, 0, 0))

    val value = GameRules.playerTeam(uuid, state)
  }

  test("known red player") {
    val uuid: UUID = UUID.randomUUID()

    val player = Player(uuid,  "Foo")
    val state: GameState.Started = GameState.Started(blueTeam = Nil, redTeam = List(player), 0, "", Color(0, 0, 0))

    val value = GameRules.playerTeam(uuid, state)
  }

  test("example test that succeeds") {
    val obtained = 42
    val expected = 42
    assertEquals(obtained, expected)
  }
}
