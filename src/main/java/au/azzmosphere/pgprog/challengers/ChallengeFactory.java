package au.azzmosphere.pgprog.challengers;

import au.azzmosphere.pgprog.challengers.adriann.MorseCodeTranslater;
import au.azzmosphere.pgprog.challengers.ideserve.MissingNumInDupArrays;
import au.azzmosphere.pgprog.challengers.ideserve.OddNumberChallenge;
import au.azzmosphere.pgprog.challengers.ideserve.ShortestPalindrome;
import au.azzmosphere.pgprog.challengers.ideserve.TwoTowerProblem;
import org.springframework.stereotype.Service;

/**
 * Given a Challenge ID the object will return the challenge concrete class.
 *
 * Created by aaron.spiteri on 17/5/17.
 */
@Service
public class ChallengeFactory {
    private interface Id2ChallengeMap {
        ChallengeInterface challenge();
        boolean isChallenge(String id);
    }

    /*
     * Future versions of this program should aim to remove this code and add it
     * to config or its own class.
     */
    private enum CHALLENGES implements Id2ChallengeMap {
        TWO_TOWER_PROBLEM {
            @Override
            public ChallengeInterface challenge() {
                return new TwoTowerProblem();
            }

            @Override
            public boolean isChallenge(String id) {
                if ("twotowerproblemctr".equals(id)) {
                    return true;
                }
                return false;
            }
        },
        MORSE_CODE {
            @Override
            public ChallengeInterface challenge() {
                return new MorseCodeTranslater();
            }

            @Override
            public boolean isChallenge(String id) {
                if ("morsecode".equals(id)) {
                    return true;
                }
                return false;
            }
        },
        MISSING_DUP_ARRAYS {
            @Override
            public ChallengeInterface challenge() {
                return new MissingNumInDupArrays();
            }

            @Override
            public boolean isChallenge(String id) {
                if ("missingnumindupreq2".equals(id)) {
                    return true;
                }
                return false;
            }
        },
        ODD_NUMBER_IN_DUP_ARRAY {
            @Override
            public ChallengeInterface challenge() {
                return new OddNumberChallenge();
            }

            @Override
            public boolean isChallenge(String id) {
                if ("oddnumberchallenge".equals(id)) {
                    return true;
                }
                return false;
            }
        },
        SHORTEST_PALINDROME {
            @Override
            public ChallengeInterface challenge() {
                return new ShortestPalindrome();
            }

            @Override
            public boolean isChallenge(String id) {
                if ("shortestpalindromectl".equals(id)) {
                    return true;
                }
                return false;
            }
        }
    }

    public ChallengeInterface challenge(String id) {
        for (CHALLENGES ch : CHALLENGES.values())  {
            if (ch.isChallenge(id)) {
                return ch.challenge();
            }
        }
        return null;
    }
}
