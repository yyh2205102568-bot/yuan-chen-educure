package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RPGCharacterTest {

    // 初期状態のテスト
    @Test
    void testInitialStatus() {
        RPGCharacter character = new RPGCharacter();

        assertEquals(1, character.getLevel(), "初期レベルは1のはず");
        assertEquals(100, character.getHP(), "初期HPは100のはず");
        assertEquals(50, character.getMP(), "初期MPは50のはず");
    }

    // 通常のレベルアップテスト
    @Test
    void testNormalLevelUp() {
        RPGCharacter character = new RPGCharacter();

        character.levelUp();

        assertEquals(2, character.getLevel(), "レベルは2になるはず");
        assertEquals(110, character.getHP(), "HPは110になるはず");
        assertEquals(55, character.getMP(), "MPは55になるはず");
    }

    // 最大レベルの境界値テスト
    @Test
    void testMaxLevel() {
        RPGCharacter character = new RPGCharacter();

        // レベル1から98まで上げる
        for (int i = 1; i < 98; i++) {
            character.levelUp();
        }

        assertEquals(98, character.getLevel(), "レベルは98のはず");

        // レベル98から99へのレベルアップは正常に行える
        character.levelUp();

        assertEquals(99, character.getLevel(), "レベルは99になるはず");

        // レベル99からのレベルアップでは例外が発生する
        IllegalStateException e = assertThrows(
            IllegalStateException.class,
            () -> character.levelUp(),
            "最大レベルでのレベルアップは例外が発生するはず"
        );

        assertEquals(
            "最大レベルに達しています",
            e.getMessage(),
            "例外メッセージが正しくない"
        );
    }
}