package com.app2.common;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PrefectureProcessor {

    private static final List<String> PREFECTURES = List.of(
        "Argentina", "Brazil", "Canada", "Chile", "Colombia", "Costa Rica", "Ecuador", "Mexico", "Peru", "United States", "Uruguay", "Venezuela",
        "Austria", "Belgium", "Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Netherlands", "Norway", "Poland", "Portugal", "Romania", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "Turkey", "United Kingdom",
        "Australia", "Bangladesh", "China", "Hong Kong", "India", "Indonesia", "Japan", "Malaysia", "New Zealand", "Philippines", "Singapore", "South Korea", "Sri Lanka", "Taiwan", "Thailand", "Vietnam",
        "Algeria", "Ghana", "Egypt", "Israel", "Kenya", "Morocco", "Nigeria", "Pakistan", "Qatar", "Saudi Arabia", "South Africa", "Tunisia", "United Arab Emirates"
    );

    // 都道府県を処理するメインメソッド
    public List<String> processPrefectures(String numStr) {
        // 入力が無効である場合
        // if (isInvalidInput(numStr)) {
        //     return new ArrayList<>();
        // }

        // 入力文字列を整数に変換
        int preNum = parseInput(numStr);
        // 変換した整数が有効な範囲内かをチェック
        if (preNum < 1 || preNum > PREFECTURES.size()) {
            // return new ArrayList<>();
            throw new InvalidParameterException("Invalid input!!");
        }

        // ランダムに都道府県を選択し、リストに追加
        return selectRandomPrefectures(preNum);
    }

    // 入力文字列がnullまたは空であるかをチェックするメソッド
    private boolean isInvalidInput(String numStr) {
        return numStr == null || numStr.isEmpty();
    }

    // 入力文字列を整数に変換するメソッド
    private int parseInput(String numStr) {
        return Integer.parseInt(numStr);
    }

    // ランダムに都道府県を選択し、リストに追加するメソッド
    private List<String> selectRandomPrefectures(int preNum) {
        List<String> nameList = new ArrayList<>(PREFECTURES);
        List<String> chosenList = new ArrayList<>();
        Random rand = new Random();

        // 指定された数だけランダムに都道府県を選択
        for (int i = 0; i < preNum; i++) {
            int randomIndex = rand.nextInt(nameList.size());
            String chosenPrefecture = nameList.get(randomIndex);
            chosenList.add(chosenPrefecture);
            nameList.remove(randomIndex);
        }

        return chosenList;
    }
}
