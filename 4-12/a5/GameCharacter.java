package a5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameCharacter {

    // キャラクター名
    private String name;

    // 装備リスト
    private List<Equipment> equipments;

    // コンストラクタ
    public GameCharacter(String name) {
        this.name = name;
        this.equipments = new ArrayList<>();
    }

    // 装備品を追加する
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    // 装備品を総合力の高い順に並べ替える
    public void sortEquipments() {
        Collections.sort(equipments);
    }

    // 装備リストを取得する
    public List<Equipment> getEquipments() {
        return equipments;
    }

    // 全装備品を番号付きで表示する
    public void showEquipments() {

        System.out.println(name + "の装備:");

        for (int i = 0; i < equipments.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + equipments.get(i)
            );
        }
    }
}