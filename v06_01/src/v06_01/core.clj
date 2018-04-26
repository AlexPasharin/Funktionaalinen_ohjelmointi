(ns v06-01.core
  (:gen-class))

; teht 1
; kahden taulukon keskiarvo-taulukko
(defn averageTemps[arr1 arr2]
  (into []
    (map #(/ (+ %1 %2) 2) arr1 arr2)
  )
)

; apufunktio - taulukon lukujen keskiarvo
(defn avg[arr]
  (/ (reduce + arr) (count arr))
)

; taulukon pos. lukujen keskiarvo
(defn averageOfPositive[arr]
  (avg (filter pos? arr))
)

; teht 2/3
; apufunktiot 

; muunna map muotoa {:kk 4 :paiva 5 :neste 5.0 :vesi 2.0}
; mapiksi muotoa {:kk 4 :paiva 5 :muuneste 3.0}
(defn normalize[map]
  (assoc 
    (dissoc map :neste :vesi)
    :muuneste 
      (double
       (- (bigdec (:neste map)) (bigdec (:vesi map)))
      )
  )
)

; filteroi food-journalista vain huhtikuun arvot ja normalisoidaan ne
(defn aprilNormalize[data]
  (into []
    (map normalize (filter #(= (:kk %) 4) data))
  )
)

(def food-journal
  [{:kk 3 :paiva 1 :neste 5.3 :vesi 2.0}
   {:kk 3 :paiva 2 :neste 5.1 :vesi 3.0}
   {:kk 3 :paiva 13 :neste 4.9 :vesi 2.0}
   {:kk 4 :paiva 5 :neste 5.0 :vesi 2.0}
   {:kk 4 :paiva 10 :neste 4.2 :vesi 2.5}
   {:kk 4 :paiva 15 :neste 4.0 :vesi 2.8}
   {:kk 4 :paiva 29 :neste 3.7 :vesi 2.0}
   {:kk 4 :paiva 30 :neste 3.7 :vesi 1.0}])

(def food-journal (aprilNormalize food-journal))

; tässä ratkaisu
(defn -main[]
  (println food-journal)
)
