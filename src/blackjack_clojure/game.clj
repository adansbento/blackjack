(ns blackjack-clojure.game
  (:require [blackjack-clojure.card-ascii-art :as card]))

(defn new-card []
  "Create a new card between 1 and 13"
  (+ (rand-int 13) 1))



(defn A-equal-eleven [card]
  "Case card 1 as A, set 11 blackjack's rule"
  (if (= card 1) 11 card))
(defn JQK-equal-teen [card]
  "Case card than more 10 as J Q K, set 10 blackjack's rule"
  (if (> card 10) 10 card))

(defn points-cards [cards]
  (let [card-without-JQK (map JQK-equal-teen cards)
        cards-with-A11 (map A-equal-eleven card-without-JQK)
        points-cards-A-1 (reduce + card-without-JQK)
        points-cards-A-11 (reduce + cards-with-A11)]
    (if (> points-cards-A-11 21) points-cards-A-1 points-cards-A-11)))

(defn player [player-name]
  (let [card1 (new-card)
        card2 (new-card)
        cards [card1 card2]
        points (points-cards cards)
        ]
    {:player-name player-name
     :cards       cards
     :points      points}
    )
  )

(defn more-card [player]
  (let [ card (new-card)
        cards (conj (:cards player) card)
        new-player (update player :cards conj card)
        points (points-cards cards)]
    (assoc new-player :points points)
    ))

(def player (player "Adão") )
(card/print-player (more-card player))
;(card/print-player (player "Adans"))
;(card/print-player (player "Braia"))
