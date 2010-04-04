;   Copyright (c) Joe Holloway. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.

(ns 
  org.zmq.clojure-zmq
  (:import [org.zmq Context Socket Poller]))

; Constants
(def NOBLOCK 1)

(def P2P 0)
(def PUB 1)
(def SUB 2)
(def REQ 3)
(def REP 4)
(def XREQ 5)
(def XREP 6)
(def UPSTREAM 7)
(def DOWNSTREAM 8)

(def HWM 1)
(def LWM 2)
(def SWAP 3)
(def AFFINITY 4)
(def IDENTITY 5)
(def SUBSCRIBE 6)
(def UNSUBSCRIBE 7)
(def RATE 8)
(def RECOVERY_IVL 9)
(def MCAST_LOOP 10)
(def SNDBUF 11)
(def RCVBUF 12)

(def POLLIN 1)
(def POLLOUT 2)
(def POLLERR 4)

; Context
(defn make-context 
  ([app-threads io-threads flags] 
    (Context. app-threads io-threads flags))
  ([app-threads io-threads] 
    (make-context app-threads io-threads 0)))

(defn destroy-context [context] 
  (.destroy context))

; Socket
(defn make-socket [context socket-type]
  (Socket. context socket-type))

(defn set-socket-option [socket option value] 
  (.setsockopt socket option value))

(defn bind [socket address]
  (.bind socket address))

(defn connect [socket address] 
  (.connect socket address))

(defn send-
  ([socket message flags]
   (.send socket message flags))
  ([socket message]
   (send- socket message 0)))

(defn recv
  ([socket flags]
    (.recv socket flags))
  ([socket]
    (recv socket 0)))

(defn destroy-socket [socket]
  (.destroy socket))

; Poller
(defn make-poller [context size]
  (Poller. context size))

(defn register [poller socket] 
  (.register poller socket))

(defn poll [poller]
  (.poll poller))

(defn poll-in [poller idx]
  (.pollin poller idx))

(defn poll-out [poller idx]
  (.pollout poller idx))

(defn poll-error [poller idx]
  (.pollerr poller idx))

(defn destroy-poller [poller]
  (.destroy poller))
                                        


