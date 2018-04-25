(ns v05-02.core
  (:gen-class))

; teht 1 ja 2
(defn evenInput? []
  (let [input (Integer. (read-line))]
    (if (pos? input)
      (if (even? input) 
          (println "Luku on parillinen")
          (println "Luku ei ole parillinen")
      )
      (do 
        (println "Negatiivinen luku ei kelpaa!")
        (recur)
      )    
    )
  )
)

; teht 3
(defn multiplysOf3 [limit] 
  (loop [x 3]
    (when (< x limit)
        (println x)
        (recur (+ x 3))
    )
  )
)

; teht 4

; apufunktio
(defn randLottoNumber[]
  (+ (rand-int 39) 1)
)

(defn drawLottoNumbers[]
  (loop [x #{}]
    (if (= (count x) 7)
      (sort x)
      (recur (conj x (randLottoNumber)))
    )
  )
)

; teht 5

(defn syt[p q]
  (if (= q 0)
    p
    (recur q (mod p q))
  )
)