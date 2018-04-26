(ns v06-02.core
  (:gen-class))

; teht 1
(defn emailSignature[formal? lang firstName lastName]
  (cond 
    (and formal? (= lang "en")) (str "Best regards, " firstName " " lastName)
    (and (not formal?) (= lang "en")) (str "Yo, I am " firstName)
    (and formal? (= lang "fi")) (str "Ystävällisin terveisin, " firstName " " lastName)
    (and (not formal?) (= lang "fi")) (str "Se on moro. " firstName)
  )
)

(def formalSignEn (partial emailSignature true "en"))

(def inFormalSignEn (partial emailSignature false "en"))

(def formalSignFi (partial emailSignature true "fi"))

(def inFormalSignFi (partial emailSignature false "fi"))

; teht 2
; a
(defn vectorMin[v]
  (map #(apply min %) v)
)


(defn teht2a[]
  (vectorMin [[1 2 3][4 5 6][7 8 9]])
)

; b
(defn seqToVector[s]
  (apply vector s)
)


(defn teht2b[]
  (seqToVector (vectorMin [[1 2 3][4 5 6][7 8 9]]))
)

; teht 3
; testaamista varten
(def vampire-database
   {0 {:makes-blood-puns? false, :has-pulse? true  :name "McFishwich"}
    1 {:makes-blood-puns? false, :has-pulse? true  :name "McMackson"}
    2 {:makes-blood-puns? true,  :has-pulse? false :name "Damon Salvatore"}
    3 {:makes-blood-puns? true,  :has-pulse? true  :name "Mickey Mouse"}})

(defn lisaa-vampyyrikantaan 
  [db mbp hp nimi]
  (assoc 
    db
    (inc (apply max (keys vampire-database)))
    {:makes-blood-puns? mbp :has-pulse? hp :name nimi}
  )
)    

; teht 4

(defn poista-vampyyrikannasta
  [db key]
  (dissoc db key)
) 

; teht 5

(defn multiplySima[sima n]
  (map (fn[x] (update x :maara #(* % n)))
  sima)
)

; testaamista varten
(def sima [{:aines "Vesi", :yksikko "litraa", :maara 4} 
{:aines "Sokeri", :yksikko "grammaa", :maara 500} 
{:aines "Sitruuna", :yksikko "kpl", :maara 2} 
{:aines "Hiiva", :yksikko "grammaa", :maara 1}])
