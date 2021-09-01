package com.amazonaws.guru.rules.javabestpractices;

import java.util.HashMap;
import java.util.Map;

public class IterateOnEntrySetRule {
    //should not flag
    public void IterateOnKeySet_NotUsingValues() {
        Map<String,String> gfg = new HashMap<String,String>();
        for (String name : gfg.keySet())
            System.out.println("key: " + name);
    }
    //should flag
    public void IterateOnKeySet_UsingValues() {
        Map<String,String> gfg = new HashMap<String,String>();
        for (String name : gfg.keySet())
            System.out.println("Value: " + gfg.get(name));
    }
    //should not flag
    public void IterateOnEntrySet() {
        Map<String,String> gfg = new HashMap<String,String>();
        for (Map.Entry<String,String> entry : gfg.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

    //should not flag
    public void logicBetweenKeySetCallAndValueCall() {
        val query = createQuery(FieldNames.CustomerId.getValue(), new ArrayList<String>(decryptedIds.keySet()));

        val request = identitySearchService.newSearchCustomersRequest(query);

        val result = this.executeRetryableTask(() -> {
            return request.call();
        }, "exception");

        final List<MatchingCustomer> matchingCustomers = result.getItems();

        for (val customer : matchingCustomers) {
            // make sure the customer id exists in the map and recover the encrypted version
            if (decryptedIds.containsKey(customer.getCustomerId())) {
                val encryptedCustomerId = decryptedIds.get(customer.getCustomerId());
            }
        }
    }

    //should not flag
    public void logicBetweenKeySetCallAndValueCall_2() {
        final Set<String> unionOfKeys = Sets.union(currentStates.keySet(), lastStates.keySet());

        for (String key : unionOfKeys) {
            final T currentState = currentStates.get(key);
            final T lastState = lastStates.get(key);

            if (currentState == null && lastState != defaultState) {
                currentChangedTimestamps.put(key, computedTimestamp);
            } else if (currentState == null && lastState == defaultState) {
                currentChangedTimestamps.put(key, lastChangedTimestamps.get(key));
            } else if (currentState == lastState) {
                currentChangedTimestamps.put(key, lastChangedTimestamps.get(key));
            }
        }
    }
}
