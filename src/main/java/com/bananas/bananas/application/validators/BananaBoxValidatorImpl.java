package com.bananas.bananas.application.validators;

import com.bananas.bananas.domain.model.BananaBox;
import com.bananas.bananas.domain.model.BananaBoxValidator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BananaBoxValidatorImpl implements BananaBoxValidator {

    private Map <String, CheckRule> rules = new HashMap <>();

    {
        rules.put("Quantidade é requerido", box -> box.getQtd() <= 0);
        rules.put("Tipo de Banana é requerido", box -> box.getBananaType() == null);
    }

    @Override
    public void checkRules(BananaBox box) {
        Set <String> violations = rules.entrySet()
                .stream()
                .filter(rule -> rule.getValue().check(box))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        if (!violations.isEmpty()) {
            throw new IllegalArgumentException("Algum campo esta vazio" + violations);
        }
    }

    private interface CheckRule {
        Boolean check(BananaBox box);
    }
}
