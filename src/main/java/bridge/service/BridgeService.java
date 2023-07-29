package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMap;
import bridge.dto.GameInformationDto;

public final class BridgeService {
    private final BridgeMap bridgeMap;
    private final BridgeGame bridgeGame;

    public BridgeService(BridgeMap bridgeMap, BridgeGame bridgeGame) {
        this.bridgeMap = bridgeMap;
        this.bridgeGame = bridgeGame;
    }

    public GameInformationDto checkBridge() {
        return new GameInformationDto(bridgeMap, bridgeGame);
    }

    public boolean step(String direction) {
        return bridgeGame.move(direction);
    }

    public boolean isClear() {
        return bridgeMap.isFinishBridge();
    }

    public void restartGame() {
        bridgeGame.retry();
        bridgeMap.reset();
    }
}
