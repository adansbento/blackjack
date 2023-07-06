(ns blackjack-clojure.game
  (:require [blackjack-clojure.card-ascii-art :as card]) )


(defn new-card []
  "Create a new card between 1 and 13"
  (+ (rand-int 13) 1))

(defn player [player-name]
  (let [card1 (new-card)
        card2 (new-card)]
    {:player-name player-name
     :cards [card1 card2]}
    )
  )

(card/print-player (player "Adans"))
(card/print-player (player "Braia"))
