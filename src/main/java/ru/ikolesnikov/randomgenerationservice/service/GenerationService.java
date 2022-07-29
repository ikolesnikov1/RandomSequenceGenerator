package ru.ikolesnikov.randomgenerationservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import ru.ikolesnikov.randomgenerationservice.object.Message;
import ru.ikolesnikov.randomgenerationservice.object.Sequence;

import java.util.*;
import java.util.stream.IntStream;

@Service
public class GenerationService {
    private List<Object> arrayList = new ArrayList<>();

    public Sequence showMainArray(Message message) throws InterruptedException {
        Thread.sleep(1000);
        String arrLength = HtmlUtils.htmlEscape(message.getName());
        arrayList = primeNumbers(Integer.parseInt(arrLength));
        return new Sequence(arrayList + " Длина массива составляет: " + arrayList.size());
    }

    public Sequence showGeneratedArray() {
        HashMap<Object, Object> hashMap = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            hashMap.put(i, getGeneratedArrays());
        }
        return new Sequence(hashMap.values() + " 5 последовательностей из 6 чисел");
    }

    public Sequence showGeneratedAuto() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Sequence(getGeneratedArrays() + " генерация последовательностей каждые 10 секунд");
    }

    private HashSet<Object> getGeneratedArrays() {
        HashSet<Object> hashSet = new HashSet<>();
        int i = 0;
        while (hashSet.size() != 6) {
            int randomIndex = (int) (Math.random() * arrayList.size());
            hashSet.add(arrayList.get(randomIndex));
            i++;
        }
        return hashSet;
    }

    private List<Object> primeNumbers(int length) {
        ArrayList<Object> result = new ArrayList<>();
        int i = 1;
        while (result.size() != length) {
            if (isPrime(i)) {
                result.add(i);
            }
            i++;
        }
        return result;
    }

    private boolean isPrime(int x) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(x)))
                .allMatch(n -> x % n != 0);
    }
}
